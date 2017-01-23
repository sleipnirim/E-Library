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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sleipnir on 22.1.17.
 */
public class GetCookies implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        List<Book> books = new ArrayList<>();
        ServiceFactory factory = ServiceFactory.getFactory();
        ViewService service = factory.getViewService();

        for (int i = 0; i < cookies.length; i++) {
            try {
                if (cookies[i].getValue().equals("id")) {
                    Book book = service.showBook(Integer.parseInt(cookies[i].getName()));
                    books.add(book);
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        if (books.size() != 0){
            request.setAttribute("status", 1);
        } else request.setAttribute("status", 2);

        request.setAttribute("books", books);
        request.getRequestDispatcher("WEB-INF/CookiesList.jsp").forward(request, response);
    }
}
