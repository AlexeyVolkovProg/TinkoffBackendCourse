package edu.hw1;

import java.util.Arrays;

/**
 * Напишите функцию, которая возвращает true,
 * если первый массив может быть вложен во второй, и false в противном случае.
 * Массив может быть вложен, если:
 * min(a1) больше чем min(a2)
 * max(a1) меньше, чем max(a2)
 * Примеры:
 * isNestable([1, 2, 3, 4], [0, 6]) -> true
 * isNestable([3, 1], [4, 0]) -> true
 * isNestable([9, 9, 8], [8, 9]) -> false
 * isNestable([1, 2, 3, 4], [2, 3]) -> false
 */
public class Task3 {

    private Task3() {

    }

    public static Boolean isNestable(int[] array1, int[] array2) {
        final String WARNINGARRAY1 = "array1 is empty";
        final String WARNINGARRAY2 = "array2 is empty";
        int max1 = Arrays.stream(array1)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(WARNINGARRAY1));

        int max2 = Arrays.stream(array2)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(WARNINGARRAY2));

        int min1 = Arrays.stream(array1)
            .min()
            .orElseThrow(() -> new IllegalArgumentException(WARNINGARRAY1));

        int min2 = Arrays.stream(array2)
            .min()
            .orElseThrow(() -> new IllegalArgumentException(WARNINGARRAY2));

        return (min1 > min2) && (max2 > max1);

    }
}
