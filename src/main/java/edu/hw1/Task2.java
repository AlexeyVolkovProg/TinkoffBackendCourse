package edu.hw1;

/**
 * Напишите функцию, которая возвращает количество цифр в десятичной форме числа.
 * Пользоваться преобразованием в строку запрещено.
 * Примеры:
 * countDigits(4666) -> 4
 * countDigits(544) -> 3
 * countDigits(0) -> 1
 */
public class Task2 {
    private Task2() {
    }

    public static int countingDigits(int number) {
        final int DIVIDER = 10;
        int counter = 1;
        int processedNumber = Math.abs(number);
        while (processedNumber > DIVIDER) {
            counter += 1;
            processedNumber /= DIVIDER;
        }
        return counter;
    }
}
