package by.zhukovski.elibrary.controller;

import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sleipnir on 17.1.17.
 */
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CommandProvider provider = CommandProvider.getInstance();
        Command command = provider.getCommand(request.getParameter("command"));
        command.execute(request, response);
        
    }
}
