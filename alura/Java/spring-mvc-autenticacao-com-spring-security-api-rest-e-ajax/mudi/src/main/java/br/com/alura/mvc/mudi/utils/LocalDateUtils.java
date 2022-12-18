package br.com.alura.mvc.mudi.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedPattern("dd/MM/yyyy");

    public static LocalDate toLocalDate(String data) {
        try {
            return LocalDate.parse(data, formatter);
        }catch (DateTimeParseException e) {
            return null;
        }
    }
}
