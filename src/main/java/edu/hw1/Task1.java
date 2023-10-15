package edu.hw1;

/**
 * Дана строка с длиной видео в формате mm:ss, например 12:44.
 * Напишите функцию, которая возвращает общую длину видео в секундах.
 * Примеры:
 * minutesToSeconds("01:00") -> 60
 * minutesToSeconds("13:56") -> 836
 * minutesToSeconds("10:60") -> -1
 * Замечания:
 * если строка некорректная, например, кол-во секунд больше или равно 60, то нужно вернуть -1
 * количество минут никак не ограничено, например, 999:59 является корректным входным значением
 */
public class Task1 {
    private Task1() {
    }

    public static Integer minutesToSeconds(String time) {
        final int MAXVALUE = 60;
        final int MINVALUE = 0;
        String[] myArray = time.split(":", 2);
        try {
            int minutes = Integer.parseInt(myArray[0]);
            int seconds = Integer.parseInt(myArray[1]);
            if (seconds >= MINVALUE && seconds <= MAXVALUE && minutes >= MINVALUE) {
                return minutes * MAXVALUE + seconds;
            } else {
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
