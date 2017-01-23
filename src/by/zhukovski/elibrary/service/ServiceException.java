package by.zhukovski.elibrary.service;

/**
 * Created by sleipnir on 18.1.17.
 */
public class ServiceException extends Exception {
    private String message;

    public ServiceException(){}

    public ServiceException(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
