package io.effective.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Slf4j
public class SimpleDateFormatTest {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(LocalDateTime date) {
        return FORMATTER.format(date);
    }

    public static LocalDateTime parseDate(String strDate) {
        return LocalDateTime.parse(strDate, FORMATTER);
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
