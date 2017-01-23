package by.zhukovski.elibrary.service;

import by.zhukovski.elibrary.bean.Book;

import java.io.InputStream;
import java.util.List;

/**
 * Created by sleipnir on 18.1.17.
 */
public interface ViewService {
    List<Book> getAll() throws ServiceException;
    Book showBook (int id) throws ServiceException;
    InputStream download (String name) throws ServiceException;
}
