package by.zhukovski.elibrary.command.impl;

import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.ViewService;
import by.zhukovski.elibrary.service.factory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;

/**
 * Created by sleipnir on 20.1.17.
 */
public class Download implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getFactory();
        ViewService service = factory.getViewService();
        try{
            InputStream is = service.download(request.getParameter("filename"));
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"",
                    request.getParameter("filename")));
            OutputStream out = response.getOutputStream();
            byte buffer[] = new byte[2048];
            int count;
            while ((count = is.read(buffer)) != -1){
                out.write(buffer, 0, count);
            }

            is.close();
            out.close();

        } catch (ServiceException e){
            e.printStackTrace();
        }
    }
}
