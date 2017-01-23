package by.zhukovski.elibrary.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sleipnir on 17.1.17.
 */
public interface Command {
    void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
