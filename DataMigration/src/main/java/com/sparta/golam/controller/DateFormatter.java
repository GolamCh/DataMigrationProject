package com.sparta.golam.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static LocalDate clean(String date) {
        String noSpaces = spaceRemove(date);
        String[] separated = splitDate(noSpaces);
        String month = fixMonth(separated[0]);
        String day = fixDay(separated[1]);
        String year = separated[2];
        String fullDate = fullDate(month, day, year);

        return stringToLocalDate(fullDate);

    }

    public static String spaceRemove(String date) {
        return date.trim();
    }

    public static String[] splitDate(String dataAsString) {
        return  dataAsString.split("/");
    }

    public static String fixMonth(String month) {
        if (month.length() < 2) {
            month = "0" + month;
        }
        return month;
    }

    public static String fixDay(String day) {
        if (day.length() < 2) {
            day = "0" + day;
        }
        return day;
    }

    public static String fullDate(String month, String day, String year) {
        return month+"/"+day+"/"+year;
    }

    public static LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date, format);
    }



}
