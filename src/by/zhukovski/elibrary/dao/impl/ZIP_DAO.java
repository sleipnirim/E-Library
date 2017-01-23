package by.zhukovski.elibrary.dao.impl;

import by.zhukovski.elibrary.dao.DAOException;
import by.zhukovski.elibrary.dao.FileDAO;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.*;

/**
 * Created by sleipnir on 19.1.17.
 */
public class ZIP_DAO implements FileDAO {

    static final int BUFFER = 2048;
    final String source = "/home/sleipnir/IdeaProjects/E-Library/web/WEB-INF/resources/Books.zip";

    @Override
    public void addBook(String name, InputStream is) throws DAOException {
        BufferedInputStream stream;
        try {
            File zip = new File(source);
            ZipFile zipFile = new ZipFile(zip);
            if (zipFile.getEntry(name) != null) throw new DAOException("File Exists");
            File tmp = File.createTempFile(zip.getName(), null, new File("/home/sleipnir/IdeaProjects/E-Library/web/WEB-INF/temp"));
            tmp.delete();
            zip.renameTo(tmp);
            FileOutputStream dest = new FileOutputStream(source, true);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            ZipInputStream zipIs = new ZipInputStream(new FileInputStream(tmp));
            out.setMethod(ZipOutputStream.DEFLATED);
            out.setLevel(Deflater.BEST_COMPRESSION);
            byte data[] = new byte[BUFFER];
            stream = new BufferedInputStream(is, BUFFER);
            ZipEntry entry = new ZipEntry(name);
            out.putNextEntry(entry);
            int count;
            while ((count = stream.read(data, 0, BUFFER)) != -1){
                out.write(data, 0, count);
            }
            stream.close();
            out.closeEntry();

            for (ZipEntry zipEntry = zipIs.getNextEntry(); zipEntry != null; zipEntry = zipIs.getNextEntry()){
                out.putNextEntry(zipEntry);
                while ((count = zipIs.read(data, 0, BUFFER)) != -1){
                    out.write(data, 0, count);
                }
            }
            out.close();
            zipIs.close();
            tmp.deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException();
        }

    }


    @Override
    public InputStream download(String name) throws DAOException {

        try {
            File file = new File(source);
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = null;

            entry = zipFile.getEntry(name);
            if (entry != null){
                InputStream is = zipFile.getInputStream(entry);
                return is;
            } else throw new DAOException("No file");
        } catch (IOException e){
            e.printStackTrace();
            throw new DAOException("File not found");
        }
    }

    @Override
    public void delete(String name) throws DAOException {
        Map<String, String> zip_properties = new HashMap<>();
        zip_properties.put("create", "false");

        URI zipDisk = URI.create("jar:file:" + source);
        FileSystem zipfs = null;

        try {
            zipfs = FileSystems.newFileSystem(zipDisk, zip_properties);

            Path path = zipfs.getPath(name);
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException("Source file error");
        } finally {
            if (zipfs != null) try {
                zipfs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
