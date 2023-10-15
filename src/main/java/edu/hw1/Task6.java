package edu.hw1;

import java.util.Arrays;

/**
 * Выберем любое четырёхзначное число n, больше 1000, в котором не все цифры одинаковы.
 * Расположим цифры сначала в порядке возрастания, затем в порядке убывания.
 * Вычтем из большего меньшее. Производя перестановки цифр и вычитания, нули следует сохранять.
 * Описанное действие назовём функцией Капрекара K(n).
 * Повторяя этот процесс с получающимися разностями,
 * не более чем за семь шагов мы получим число 6174, которое будет затем воспроизводить само себя.
 * Это свойство числа 6174 было открыто в 1949 году. индийским математиком Д. Р. Капрекаром,
 * в честь которого оно и получило своё название.
 * Пример выполнения K(3524):
 * 5432 – 2345 = 3087
 * 8730 – 0378 = 8352
 * 8532 – 2358 = 6174
 * 7641 – 1467 = 6174
 * Требуется написать рекурсивную функцию, которая для заданного числа будет возвращать количество шагов,
 * которые нужно сделать чтобы получить 6174.
 * Например, для числа выше ответ будет равен 3.
 * Другие примеры:
 * countK(6621) -> 5
 * countK(6554) -> 4
 * countK(1234) -> 3
 */
public class Task6 {

    static final int MAX_VALUE = 1000;
    static final int END_VALUE = 6174;

    static final int MAX_STEPS = 7;

    private Task6() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int n) {
        if (n < MAX_VALUE || digitsEqual(n)) {
            throw new IllegalArgumentException("Число не подходит по условию");
        }
        return countKRecursive(n, 0);
    }

    @SuppressWarnings("MagicNumber")
    private static int countKRecursive(int n, int steps) {
        if (n == END_VALUE) {
            return steps;
        }
        if (steps >= MAX_STEPS) {
            return -1;
        }
        int kn = kaprekar(n);
        return countKRecursive(kn, steps + 1);
    }

    @SuppressWarnings("MagicNumber")
    private static int kaprekar(int n) {
        String numStr = String.format("%04d", n);
        char[] ascending = numStr.toCharArray();
        char[] descending = numStr.toCharArray();
        Arrays.sort(ascending);
        Arrays.sort(descending);
        for (int i = 0; i < descending.length / 2; i++) {
            char temp = descending[i];
            descending[i] = descending[descending.length - 1 - i];
            descending[descending.length - 1 - i] = temp;
        }
        int ascendingNum = Integer.parseInt(new String(ascending));
        int descendingNum = Integer.parseInt(new String(descending));
        if (ascendingNum >= descendingNum) {
            return ascendingNum - descendingNum;
        } else {
            return descendingNum - ascendingNum;
        }
    }

    @SuppressWarnings("MagicNumber")
    private static boolean digitsEqual(int n) {
        int n1 = n;
        int currentDigit = n1 % 10;
        while (n1 > 0) {
            if (n1 % 10 != currentDigit) {
                return false;
            }
            n1 /= 10;
        }
        return true;
    }

}
