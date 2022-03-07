package ru.clevertec.tasks.olga.plugin.downloader;


import ru.clevertec.tasks.olga.plugin.downloader.exception.ServiceException;

public class DownloaderService {

    private static final DownloaderService instance = new DownloaderService();

    private static final FileDownloader downloader = new FileDownloader();

    public static DownloaderService getInstance(){
        return instance;
    }

    public FileDownloader getDownloader() {
        return downloader;
    }

        public void download(String uri, String destination) throws ServiceException {
        downloader.downloadFromUri(uri, destination);
    }
}
