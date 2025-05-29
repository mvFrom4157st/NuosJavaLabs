package com.nuos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Printer {
    public void printDouble(String description, double value) {
        System.out.println(description + ": " + value);
    }

    public void printDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Current Date/Time: " + formattedDateTime);
    }
}
