package by.zhukovski.elibrary.command.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.ViewService;
import by.zhukovski.elibrary.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sleipnir on 19.1.17.
 */
public class ShowBook implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idBook");
        Book book = null;

        ServiceFactory factory = ServiceFactory.getFactory();
        ViewService service = factory.getViewService();
        try {
            book = service.showBook(Integer.parseInt(id));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute("book", book);

        String url = null;
        if(request.getParameter("page").equals("show")){
            Cookie cookie = new Cookie(new String(Integer.toString(book.getId())), "id");
            cookie.setMaxAge(60*5);
            response.addCookie(cookie);
            url = "/WEB-INF/Book.jsp";
        }
        if(request.getParameter("page").equals("edit")){
            url = "/WEB-INF/editBook.jsp";
        }


        request.getRequestDispatcher(url).forward(request, response);

    }
}
