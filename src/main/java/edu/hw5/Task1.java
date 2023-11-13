package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Вас попросили сделать аналитику для компьютерного клуба:
 * нужно посчитать, сколько времени в среднем посетители проводят времени за один сеанс.
 * На вход функции даётся набор строк вида 2022-03-12, 20:20 - 2022-03-12, 23:50.
 * Например, для входных данных
 * 2022-03-12, 20:20 - 2022-03-12, 23:50
 * 2022-04-01, 21:30 - 2022-04-02, 01:20
 * Вывод должен быть 3ч 40м
 * Программа не должна учитывать часовые пояса, дополнительные секунды
 * и другие особые случаи - день может длиться ровно 24 часа.
 * Для решения задания может пригодиться класс Duration.
 */

public class Task1 {

    private Task1() {

    }

    static String formatResult(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        return String.format("%dч %02dм", hours, minutes);
    }

    static Duration makeResults(String input) {
        String[] twoTime = input.split(" - ");
        String startDateTimeStr = twoTime[0];
        String endDateTimeStr = twoTime[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, formatter);
        return Duration.between(startDateTime, endDateTime);
    }
}
