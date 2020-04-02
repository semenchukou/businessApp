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
import java.util.List;

public class EditCommand implements Command {

    final String urlPattern = "edit";

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
                Player player = daoPlayer.getPlayerByID(Integer.parseInt(pl_id));
                request.setAttribute("player", player);
                clubs = daoClub.getAllClubs();
                request.setAttribute("clubs", clubs);
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/editChosenPlayerView.jsp");
                dispatcher.forward(request, response);
            } else if (cl_id != null && !cl_id.equals("")){
                Club club = daoClub.getClubByID(Integer.parseInt(cl_id));
                request.setAttribute("club", club);
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/editChosenClubView.jsp");
                dispatcher.forward(request, response);
            } else {
                if (request.getParameter("dict").equals("clubs")) {
                    clubs = daoClub.getAllClubs();
                    request.setAttribute("clubs", clubs);
                    System.out.println(clubs);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/editClubView.jsp");
                    dispatcher.forward(request, response);
                } else {
                    players = daoPlayer.getAllPlayers();
                    request.setAttribute("players", players);
                    System.out.println(players);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/editPlayerView.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.toString();
        }
    }
}
