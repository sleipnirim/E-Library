package by.zhukovski.elibrary.dao;

import java.io.InputStream;

/**
 * Created by sleipnir on 19.1.17.
 */
public interface FileDAO {
    void addBook (String name, InputStream is) throws DAOException;
    InputStream download (String name) throws DAOException;
    void delete (String name) throws DAOException;
}
