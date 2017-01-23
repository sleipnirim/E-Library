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
 * Created by sleipnir on 22.1.17.
 */
public class EditBook implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setTitle(request.getParameter("author"));
        book.setAuthor(request.getParameter("title"));
        book.setDescription(request.getParameter("description"));
        book.setYear(Integer.parseInt(request.getParameter("year")));
        book.setId(Integer.parseInt(request.getParameter("idBook")));

        ServiceFactory factory = ServiceFactory.getFactory();
        EditService service = factory.getEditService();
        Book newBook = null;
        try {
            newBook = service.editBook(book);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("book", newBook);
        request.getRequestDispatcher("WEB-INF/Book.jsp").forward(request, response);


    }
}
