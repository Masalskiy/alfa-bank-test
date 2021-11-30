package com.masalski.alfa;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Util {
    public String getHistDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DATE, -1);
        return dateFormatter.format(calendar.getTime());
    }

    public String createHtml(String url){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <img src=" + url +">\n" +
                "</body>\n" +
                "</html>";
    }
}
