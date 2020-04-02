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

public class DeleteCommand implements Command {

    final String urlPattern = "delete";

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
        String pl_id = request.getParameter("player_id");
        String cl_id = request.getParameter("club_id");
        try {
            DAOPlayer daoPlayer = new DAOPlayer();
            DAOClub daoClub = new DAOClub();
            if (pl_id != null && !pl_id.equals("")) {
                daoPlayer.deletePlayer(Integer.parseInt(pl_id));
                players = daoPlayer.getAllPlayers();
                request.setAttribute("players", players);
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/deletePlayerView.jsp");
                dispatcher.forward(request, response);
            } else if (cl_id != null && !cl_id.equals("")){
                daoClub.deleteClub(Integer.parseInt(cl_id));
                clubs = daoClub.getAllClubs();
                request.setAttribute("clubs", clubs);
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/deleteClubView.jsp");
                dispatcher.forward(request, response);
            } else {
                if (request.getParameter("dict").equals("clubs")) {
                    clubs = daoClub.getAllClubs();
                    request.setAttribute("clubs", clubs);
                    System.out.println(clubs);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/deleteClubView.jsp");
                    dispatcher.forward(request, response);
                } else {
                    players = daoPlayer.getAllPlayers();
                    request.setAttribute("players", players);
                    System.out.println(players);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/deletePlayerView.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.toString();
        }
    }
}
