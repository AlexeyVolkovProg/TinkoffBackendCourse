package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * На вход подаётся список объектов одного типа. Верните частотный словарь этого списка.
 * Примеры:
 * freqDict(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 2}
 * freqDict(["this", "and", "that", "and"]) → {"that": 1, "and": 2, "this": 1}
 * freqDict(["код", "код", "код", "bug"]) → {"код": 3, "bug": 1}
 * freqDict([1, 1, 2, 2]) → {1: 2, 2: 2}
 */
public class Task3 {

    private Task3() {

    }

    public static <T> Map<T, Long> freqDict(List<T> list) {
        return list.stream()
            .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    }
}
