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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AddCommand implements Command {

    final String urlPattern = "add";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;
        List clubs = null;
        Boolean cl = false;
        try {
            DAOPlayer daoPlayer = new DAOPlayer();
            DAOClub daoClub = new DAOClub();
            clubs = daoClub.getAllClubs();
            System.out.println(request.getParameter("dict"));
            if (request.getParameter("dict").equals("clubs")) {
                if(request.getParameter("name") != null && !request.getParameter("name").equals("") &&
                        request.getParameter("coach") != null && !request.getParameter("coach").equals("") &&
                        request.getParameter("year") != null && !request.getParameter("year").equals("")
                ) {
                    Club club = new Club(
                            request.getParameter("name"),
                            request.getParameter("coach"),
                            Integer.parseInt(request.getParameter("year")));
                    daoClub.insertClub(club);
                }
                cl = true;
            } else {
                if(request.getParameter("name") != null && !request.getParameter("name").equals("") &&
                        request.getParameter("transfer") != null && !request.getParameter("transfer").equals("") &&
                        request.getParameter("goals") != null && !request.getParameter("goals").equals("") &&
                        request.getParameter("birth_date") != null && !request.getParameter("birth_date").equals("") &&
                        request.getParameter("club_id") != null && !request.getParameter("club_id").equals("")
                ) {
                    Player player = new Player(
                            request.getParameter("name"),
                            new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")),
                            Float.parseFloat(request.getParameter("transfer")),
                            Integer.parseInt(request.getParameter("goals")),
                            Integer.parseInt(request.getParameter("club_id"))
                    );
                    daoPlayer.insertPlayer(player);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.toString();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("clubs", clubs);
        if (cl) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/addClubView.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/addPlayerView.jsp");
            dispatcher.forward(request, response);
        }
    }
}
