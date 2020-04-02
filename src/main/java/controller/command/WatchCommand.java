package controller.command;


import model.DAO.DAOClub;
import model.DAO.DAOPlayer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WatchCommand implements Command {

    final String urlPattern = "watch";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;
        List clubs = null;
        List players = null;
        Boolean cl = false;
        Boolean current_player = false;
        try {
            DAOPlayer daoPlayer = new DAOPlayer();
            DAOClub daoClub = new DAOClub();
            if (request.getParameter("dict").equals("clubs")) {
                clubs = daoClub.getAllClubs();
                request.setAttribute("clubs", clubs);
                System.out.println(clubs);
                cl = true;
            } else {
                players = daoPlayer.getAllPlayers();
                request.setAttribute("players", players);
                System.out.println(players);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.toString();
        }
        request.setAttribute("errorString", errorString);
        if (cl) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/clubsView.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/playersView.jsp");
            dispatcher.forward(request, response);
        }
    }
}
