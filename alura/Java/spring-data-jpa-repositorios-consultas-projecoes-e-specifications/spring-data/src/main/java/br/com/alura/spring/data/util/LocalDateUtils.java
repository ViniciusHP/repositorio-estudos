package br.com.alura.spring.data.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtils {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");

    public static LocalDate parse(String data) {
        return LocalDate.parse(data, dtf);
    }
}
