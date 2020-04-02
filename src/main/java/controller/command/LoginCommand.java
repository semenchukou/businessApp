package controller.command;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {

    final String urlPattern = "login";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;
        Boolean err = false;
        try {
            String fio = request.getParameter("fio");
            if (fio == "")
                throw new Exception("Invalid fio");
            int course = Integer.parseInt(request.getParameter("course"));
            int group = Integer.parseInt(request.getParameter("group"));
            int year = Integer.parseInt(request.getParameter("year"));
            HttpSession session = request.getSession();
            session.setAttribute("fio", fio);
            session.setAttribute("course", course);
            session.setAttribute("group", group);
            session.setAttribute("year", year);
        } catch (Exception e) {
            e.printStackTrace();
            err = true;
            errorString = e.toString();
        }

        request.setAttribute("errorString", errorString);

        if (err) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/loginView.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/homeView.jsp");
            dispatcher.forward(request, response);
        }
    }
}
