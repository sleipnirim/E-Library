package by.zhukovski.elibrary.command.impl;

import by.zhukovski.elibrary.bean.Book;
import by.zhukovski.elibrary.command.Command;
import by.zhukovski.elibrary.service.EditService;
import by.zhukovski.elibrary.service.ServiceException;
import by.zhukovski.elibrary.service.factory.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by sleipnir on 18.1.17.
 */
public class AddBook implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Book book = new Book();
        String command = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {

            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(20*1024*1024);
        factory.setRepository(new File("/upload"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(20*1024*1024);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {


                if (item.isFormField()) {
                    switch (item.getFieldName()){
                        case "title" : book.setTitle(item.getString("UTF-8")); break;
                        case "author" : book.setAuthor(item.getString("UTF-8")); break;
                        case "description" : book.setDescription(item.getString("UTF-8")); break;
                        case "year" : book.setYear(Integer.parseInt(item.getString())); break;
                    }

                } else {
                    book.setContent(item.getName());
                    try {
                        InputStream is = item.getInputStream();

                        ServiceFactory fact = ServiceFactory.getFactory();
                        EditService service = fact.getEditService();

                        try {
                            service.addBook(book, is);
                            request.getRequestDispatcher("/IndexServlet").forward(request, response);
                        } catch (ServiceException e){
                            e.printStackTrace();

                        }

                    } catch (IOException e1) {
                        e1.printStackTrace();

                    }



                }
            }
        } catch (FileUploadException e){
            e.printStackTrace();
        }
    }
}
