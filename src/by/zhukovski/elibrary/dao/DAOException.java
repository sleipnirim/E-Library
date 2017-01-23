package by.zhukovski.elibrary.dao;

/**
 * Created by sleipnir on 18.1.17.
 */
public class DAOException extends Exception{
    private String message;

    public DAOException(){}

    public DAOException(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
