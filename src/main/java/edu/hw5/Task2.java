package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * Напишите программу, которая ищет все пятницы, выпадающие на 13-е число в заданном году.
 * Для 1925 года вывод может выглядеть следующим образом:
 * [1925-02-13, 1925-03-13, 1925-11-13]. Для 2024 года: [2024-09-13, 2024-12-13].
 * После этого используя TemporalAdjuster, напишите функцию, которая для заданной
 * даты ищет следующую ближайшую пятницу 13.
 */
public class Task2 {
    private Task2() {

    }

    @SuppressWarnings("MagicNumber")
    static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date);
            }
        }
        return fridayThe13ths;
    }

    @SuppressWarnings("MagicNumber")
    static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withDayOfMonth(13);
    }
}
