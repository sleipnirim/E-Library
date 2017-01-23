package by.zhukovski.elibrary.dao;

import by.zhukovski.elibrary.bean.Book;

import java.util.List;

/**
 * Created by sleipnir on 18.1.17.
 */
public interface DataDAO {
    List<Book> getAll() throws DAOException;
    void addBook (Book book) throws DAOException;
    Book showBook (int id) throws DAOException;
    void delete (int id) throws DAOException;
    Book editBook (Book book) throws DAOException;

}
