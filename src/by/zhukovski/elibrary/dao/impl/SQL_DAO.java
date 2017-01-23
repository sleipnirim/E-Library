package by.zhukovski.elibrary.dao.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.dao.DAOException;
import by.zhukovski.elibrary.dao.DataDAO;
import by.zhukovski.elibrary.dao.sql.SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sleipnir on 18.1.17.
 */
public class SQL_DAO implements DataDAO{

    @Override
    public List<Book> getAll() throws DAOException{
        Connection conn = null;
        String query = "SELECT * FROM Books";
        List<Book> books = new ArrayList<>();
        conn = SQLConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.isBeforeFirst()){
                while (rs.next()){
                    Book book = new Book();
                    book.setTitle(rs.getString("Title"));
                    book.setAuthor(rs.getString("Author"));
                    book.setDescription(rs.getString("Description"));
                    book.setContent(rs.getString("Content"));
                    book.setYear(Integer.parseInt(rs.getString("Year")));
                    book.setId(Integer.parseInt(rs.getString("idBooks")));
                    books.add(book);
                }
            } else {
                return null;
            }


            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("DataBase error");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void addBook(Book book) throws DAOException {
        Connection conn;

        String query = "INSERT INTO `ELib`.`Books` (`Title`, `Description`, `Content`, `Author`, `Year`) VALUES" +
                " ('" + book.getTitle() + "', '" + book.getDescription() + "', '" + book.getContent() + "', " +
                "'" + book.getAuthor() + "', '" + book.getYear() + "');";

        conn = SQLConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);


        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("Database error");
        } finally {
            try {
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public Book showBook(int id) throws DAOException {
        Connection conn;
        String query  = "SELECT * FROM Books WHERE idBooks = '"+id+"';";
        conn = SQLConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            Book book = new Book();
            book.setTitle(rs.getString("Title"));
            book.setAuthor(rs.getString("Author"));
            book.setDescription(rs.getString("Description"));
            book.setContent(rs.getString("Content"));
            book.setYear(Integer.parseInt(rs.getString("Year")));
            book.setId(Integer.parseInt(rs.getString("idBooks")));

            return book;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Database error");
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Connection conn = null;
        String query = "DELETE FROM Books WHERE idBooks = '"+ id + "';";

        conn = SQLConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Database error");
        }
    }

    @Override
    public Book editBook(Book book) throws DAOException {
        Connection conn = null;
        String query = "UPDATE Books SET Title = '" + book.getTitle() + "', Author = '" + book.getAuthor()
                + "', Description = '" + book.getDescription()+ "', Year = '" + book.getYear()
                + "' WHERE idBooks = '" + book.getId() + "';";

        conn = SQLConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Database error");
        }

        return showBook(book.getId());
    }

}
