package by.zhukovski.elibrary.dao.factory;

import by.zhukovski.elibrary.dao.DataDAO;
import by.zhukovski.elibrary.dao.FileDAO;
import by.zhukovski.elibrary.dao.impl.SQL_DAO;
import by.zhukovski.elibrary.dao.impl.ZIP_DAO;

/**
 * Created by sleipnir on 18.1.17.
 */
public class DAOFactory {
    private static final DAOFactory FACTORY = new DAOFactory();

    private DataDAO dataDAO = new SQL_DAO();

    private FileDAO fileDAO = new ZIP_DAO();

    private DAOFactory(){}

    public static DAOFactory getFactory() {
        return FACTORY;
    }

    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public FileDAO getFileDAO() {
        return fileDAO;
    }
}
