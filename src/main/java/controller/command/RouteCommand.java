package controller.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RouteCommand implements Command {

    final String urlPattern = "router";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        if (request.getParameter("bt").equals("watch")) {
            new WatchCommand().doGet(request, response, servletContext);
        } else if(request.getParameter("bt").equals("delete")) {
            new DeleteCommand().doGet(request, response, servletContext);
        } else if(request.getParameter("bt").equals("add")) {
            new AddCommand().doGet(request, response, servletContext);
        } else if(request.getParameter("bt").equals("edit")) {
            new EditCommand().doGet(request, response, servletContext);
        }
    }
}
