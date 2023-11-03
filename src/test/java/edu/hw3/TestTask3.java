package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask3 {
    @Test
    public void testEmptyList() {
        List<String> emptyList = Arrays.asList();
        Map<String, Long> result = Task3.freqDict(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleElementList() {
        List<Integer> singleElementList = Arrays.asList(42);
        Map<Integer, Long> result = Task3.freqDict(singleElementList);
        assertEquals(1, result.size());
        assertEquals(1, result.get(42));
    }

    @Test
    public void testMultipleElementList() {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        Map<String, Long> result = Task3.freqDict(list);
        assertEquals(3, result.size());
        assertEquals(2, result.get("apple"));
        assertEquals(2, result.get("banana"));
        assertEquals(1, result.get("cherry"));
    }


}
