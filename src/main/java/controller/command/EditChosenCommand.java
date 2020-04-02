package controller.command;


import model.DAO.DAOClub;
import model.DAO.DAOPlayer;
import model.entities.Club;
import model.entities.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EditChosenCommand implements Command {

    final String urlPattern = "editChosen";

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
            if(request.getParameter("bt").equals("Edit")) {
                if (pl_id != null && !pl_id.equals("")) {
                    Player player = new Player(
                            request.getParameter("name"),
                            Float.parseFloat(request.getParameter("transfer")),
                            Integer.parseInt(request.getParameter("goals")),
                            Integer.parseInt(request.getParameter("club_id"))
                    );
                    daoPlayer.updatePlayer(player, Integer.parseInt(pl_id));
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/homeView.jsp");
                    dispatcher.forward(request, response);
                } else if (cl_id != null && !cl_id.equals("")) {
                    Club club = new Club(
                            request.getParameter("name"),
                            request.getParameter("coach"),
                            Integer.parseInt(request.getParameter("year")));
                    daoClub.updateClub(club, Integer.parseInt(cl_id));
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/homeView.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/homeView.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.toString();
        }
    }
}
