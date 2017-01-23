package by.zhukovski.elibrary.controller;

import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sleipnir on 22.1.17.
 */
@WebServlet(name = "CookiesList")
public class CookiesList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandProvider provider = CommandProvider.getInstance();
        Command command = provider.getCommand("cookies");
        command.execute(request, response);
    }
}
