package by.zhukovski.elibrary.command.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.service.EditService;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sleipnir on 21.1.17.
 */
public class Delete implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getFactory();
        EditService service = factory.getEditService();
        try {

            service.delete(Integer.parseInt(request.getParameter("id")), request.getParameter("content"));

            request.getRequestDispatcher("/IndexServlet").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
