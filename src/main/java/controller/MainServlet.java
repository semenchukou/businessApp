package controller;

import controller.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Map<String, Command> commands;

    public MainServlet() {
        super();
        this.commands = new HashMap<>();
    }

    @Override
    public void init() {
        Command[] commands = {new HomeCommand(), new LoginCommand(),
                new RouteCommand(), new WatchCommand(), new DeleteCommand(),
                new AddCommand(), new EditCommand(), new EditChosenCommand()};
        for (Command c : commands) {
            this.commands.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/loginView.jsp");
            dispatcher.forward(request, response);
        } else if (commands.containsKey(command)) {
            commands.get(command).doGet(request, response, this.getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/loginView.jsp");
            dispatcher.forward(request, response);
        } else if (commands.containsKey(command)) {
            commands.get(command).doPost(request, response, this.getServletContext());
        }
    }
}
