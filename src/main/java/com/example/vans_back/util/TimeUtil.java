package com.example.vans_back.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String instantToString(Instant instant) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm")
                .withZone(ZoneId.systemDefault());

        String formattedString = formatter.format(instant);

        return formattedString;
    }
}
