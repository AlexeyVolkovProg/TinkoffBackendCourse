package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * Существует много способов указать дату, например:
 * 2020-10-10
 * 2020-12-2
 * 1/3/1976
 * 1/3/20
 * tomorrow
 * today
 * yesterday
 * 1 day ago
 * 2234 days ago
 * Напишите метод Optional LocalDate parseDate(String string), который распознает перечисленные выше форматы.
 * Если строка передана в одном из форматов, то функция должна преобразовать ее в LocalDate и вернуть в Optional.
 * Если ни один из форматов не подошёл, то возвращается Optional.empty().
 */
public class Task3 {
    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String string1) {
        LocalDate localDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            localDate = LocalDate.parse(string1, formatter);
        } catch (IllegalArgumentException | DateTimeParseException ignored) {

        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yy");
            localDate = LocalDate.parse(string1, formatter);
        } catch (IllegalArgumentException | DateTimeParseException ignored) {
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            localDate = LocalDate.parse(string1, formatter);
        } catch (IllegalArgumentException | DateTimeParseException ignored) {
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            localDate = LocalDate.parse(string1, formatter);
        } catch (IllegalArgumentException | DateTimeParseException ignored) {
        }

        if ("tomorrow".equalsIgnoreCase(string1)) {
            localDate = LocalDate.now().plusDays(1);
        } else if ("today".equalsIgnoreCase(string1)) {
            localDate = LocalDate.now();
        } else if ("yesterday".equalsIgnoreCase(string1)) {
            localDate = LocalDate.now().minusDays(1);
        } else if (string1.endsWith(" day ago")) {
            try {
                int daysAgo = Integer.parseInt(string1.split(" ")[0]);
                localDate = LocalDate.now().minusDays(daysAgo);
            } catch (NumberFormatException ignored) {
            }
        } else if (string1.endsWith(" days ago")) {
            try {
                int daysAgo = Integer.parseInt(string1.split(" ")[0]);
                localDate = LocalDate.now().minusDays(daysAgo);
            } catch (NumberFormatException ignored) {
            }
        }
        if (localDate != null) {
            return Optional.of(localDate);
        }
        return Optional.empty();

    }
}
