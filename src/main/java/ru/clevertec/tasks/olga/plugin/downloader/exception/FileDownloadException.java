package ru.clevertec.tasks.olga.plugin.downloader.exception;

public class FileDownloadException extends ServiceException {

    public FileDownloadException() {
        super();
    }

    public FileDownloadException(String message) {
        super(message);
    }

    public FileDownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDownloadException(Throwable cause) {
        super(cause);
    }
}
