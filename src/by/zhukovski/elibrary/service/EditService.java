package by.zhukovski.elibrary.service;

import by.zhukovski.elibrary.bean.Book;

import java.io.InputStream;

/**
 * Created by sleipnir on 18.1.17.
 */
public interface EditService {
    void addBook (Book book, InputStream content) throws ServiceException;
    void delete (int id, String content) throws ServiceException;
    Book editBook (Book book) throws  ServiceException;

}
