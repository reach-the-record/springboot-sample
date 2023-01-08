package com.example.springbootsample.util.common;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateTimeUtil {
    private final static DateTimeFormatter[] DATE_TIME_FORMATTERS = new DateTimeFormatter[]{
            ISODateTimeFormat.dateTime(),
            ISODateTimeFormat.dateTimeNoMillis(),
            DateTimeFormat.forPattern("yyyy-MM-dd"),
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.ssZZ"),
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSZZ"),
            ISODateTimeFormat.date().withZone(DateTimeZone.forID("Asia/Seoul"))
    };

    public static DateTime parse(String dateTimeString) throws IllegalArgumentException {
        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
            try {
                return DateTime.parse(dateTimeString, formatter);
            } catch (IllegalArgumentException ignored) {
            }
        }

        throw new IllegalArgumentException("Invalid date!");
    }


}
