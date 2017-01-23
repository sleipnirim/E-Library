package by.zhukovski.elibrary.command.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.ViewService;
import by.zhukovski.elibrary.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sleipnir on 18.1.17.
 */
public class Index implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getFactory();
        ViewService service = factory.getViewService();
        List<Book> books = null;
        try {
            books = service.getAll();
            request.setAttribute("status", "1");
            request.setAttribute("books", books);
        } catch (ServiceException e) {
            e.printStackTrace();
            request.setAttribute("status", "2");
        }

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

    }
}
