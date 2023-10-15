package edu.hw1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

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
        IntSummaryStatistics stats1 = Arrays.stream(array1)
            .summaryStatistics();
        IntSummaryStatistics stats2 = Arrays.stream(array2)
            .summaryStatistics();

        if (stats1.getCount() == 0 || stats2.getCount() == 0) {
            throw new IllegalArgumentException("Input array is empty");
        }

        return (stats1.getMin() > stats2.getMin()) && (stats1.getMax() < stats2.getMax());
    }

}
