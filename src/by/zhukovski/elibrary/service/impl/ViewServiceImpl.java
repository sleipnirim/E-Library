package by.zhukovski.elibrary.service.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.dao.DAOException;
import by.zhukovski.elibrary.dao.DataDAO;
import by.zhukovski.elibrary.dao.FileDAO;
import by.zhukovski.elibrary.dao.factory.DAOFactory;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.ViewService;

import java.io.InputStream;
import java.util.List;

/**
 * Created by sleipnir on 18.1.17.
 */
public class ViewServiceImpl implements ViewService {
    @Override
    public List<Book> getAll() throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        DataDAO dao = factory.getDataDAO();
        try {
            List<Book> books = dao.getAll();
            return books;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Book showBook(int id) throws ServiceException {
        DAOFactory factory = DAOFactory.getFactory();
        DataDAO dataDAO = factory.getDataDAO();
        try {
            Book book = dataDAO.showBook(id);
            return book;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public InputStream download(String name) throws ServiceException {

        DAOFactory factory = DAOFactory.getFactory();
        FileDAO fileDAO = factory.getFileDAO();
        try{
            InputStream is = fileDAO.download(name);
            return is;
        } catch (DAOException e){
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }


    }
}
