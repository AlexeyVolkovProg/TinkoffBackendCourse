package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    public void testFindFridayThe13ths() {
        List<LocalDate> result1925 = Task2.findFridayThe13ths(1925);
        List<LocalDate> result2024 = Task2.findFridayThe13ths(2024);

        assertEquals(3, result1925.size());
        assertEquals(LocalDate.of(1925, 2, 13), result1925.get(0));
        assertEquals(LocalDate.of(1925, 3, 13), result1925.get(1));
        assertEquals(LocalDate.of(1925, 11, 13), result1925.get(2));

        assertEquals(2, result2024.size());
        assertEquals(LocalDate.of(2024, 9, 13), result2024.get(0));
        assertEquals(LocalDate.of(2024, 12, 13), result2024.get(1));
    }

    @Test
    public void testFindNextFridayThe13th() {
        LocalDate date1 = LocalDate.of(2023, 5, 20);
        LocalDate result1 = Task2.findNextFridayThe13th(date1);
        assertEquals(LocalDate.of(2023, 5, 13), result1);

        LocalDate date2 = LocalDate.of(2022, 12, 15);
        LocalDate result2 = Task2.findNextFridayThe13th(date2);
        assertEquals(LocalDate.of(2022, 12, 13), result2);

        LocalDate date3 = LocalDate.of(2021, 8, 1);
        LocalDate result3 = Task2.findNextFridayThe13th(date3);
        assertEquals(LocalDate.of(2021, 8, 13), result3);
    }
}
