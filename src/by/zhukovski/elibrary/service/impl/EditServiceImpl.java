package by.zhukovski.elibrary.service.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.dao.DAOException;
import by.zhukovski.elibrary.dao.DataDAO;
import by.zhukovski.elibrary.dao.FileDAO;
import by.zhukovski.elibrary.dao.factory.DAOFactory;
import by.zhukovski.elibrary.service.EditService;
import by.zhukovski.elibrary.service.ServiceException;

import java.io.InputStream;

/**
 * Created by sleipnir on 18.1.17.
 */
public class EditServiceImpl implements EditService {

    @Override
    public void addBook(Book book, InputStream is) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        DataDAO dataDAO = factory.getDataDAO();
        FileDAO fileDAO = factory.getFileDAO();

        try {
            dataDAO.addBook(book);
            fileDAO.addBook(book.getContent(), is);;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(int id, String content) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        DataDAO dataDAO = factory.getDataDAO();
        FileDAO fileDAO = factory.getFileDAO();

        try {
            dataDAO.delete(id);
            fileDAO.delete(content);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Book editBook(Book book) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        DataDAO dataDAO = factory.getDataDAO();
        Book newBook;

        try {
            newBook = dataDAO.editBook(book);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
        return newBook;
    }
}
