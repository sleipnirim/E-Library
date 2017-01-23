package by.zhukovski.elibrary.dao.sql;

import by.zhukovski.elibrary.dao.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by sleipnir on 18.1.17.
 */
public class SQLConnection {
    public static Connection getConnection() throws DAOException{

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
            e.printStackTrace();
            throw new DAOException("Driver error");
        }
        Connection conn = null;
        Properties prop = new Properties();

        prop.setProperty("useUnicode", "true");
        prop.setProperty("characterEncodind", "UTF-8");
        prop.setProperty("user", "root");
        prop.setProperty("password", "1234");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ELib", prop);


        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Driver error");
        }
        return conn;
    }
}
