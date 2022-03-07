package ru.clevertec.tasks.olga.plugin.downloader;

import ru.clevertec.tasks.olga.plugin.downloader.exception.InvalidPathException;
import ru.clevertec.tasks.olga.plugin.downloader.exception.InvalidUrlException;
import ru.clevertec.tasks.olga.plugin.downloader.util.URLWorker;
import ru.clevertec.tasks.olga.plugin.downloader.exception.ServiceException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownloader {

    private URLWorker urlWorker;

    public FileDownloader(){
        urlWorker= new URLWorker();
    }

    public void downloadFromUri(String urlStr, String path) throws ServiceException {
        if(urlStr == null || !urlWorker.validateUrl(urlStr)){
            throw new InvalidUrlException("Invalid or empty uri");
        }
        if (path == null || path.isEmpty()){
            throw new InvalidPathException("No path was specified");
        }
        try {
            URL url = new URL(urlStr);
            InputStream in = url.openStream();
            String extension = urlWorker.defineExtention(urlStr);
            FileOutputStream fos = new FileOutputStream(new File(path + extension));

            int length = -1;
            byte[] buffer = new byte[1024];
            while ((length = in.read(buffer)) > -1) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            in.close();
        } catch (IOException e){
            throw new ServiceException(e);
        }
    }
}

//        URL url = new URL("http://techslides.com/demos/sample-videos/small.mp4");
//            URL url = new URL("https://pbs.twimg.com/media/FLjbQO3VQAELqxr.jpg");
//            URL url = new URL("https://rep.bntu.by/bitstream/handle/data/37608/Optimizaciya_sostava_grupp_programmistov_po_professionalnoj_kvalifikacii.pdf");
