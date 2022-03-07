package ru.clevertec.tasks.olga.plugin.downloader.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLWorker {
    private final Pattern pattern;

    public URLWorker(){
        pattern = Pattern.compile("^(https?|ftp|file):\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|](\\.[^.\\/]+$)");
    }

    public boolean validateUrl(String url) {
         Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public String defineExtention(String url) {
        Matcher matcher = pattern.matcher(url);
        matcher.find();
        return matcher.group(2);
//        if (matcher.matches()){
//            return matcher.group(2);
//        }
//        return "";
    }

}
