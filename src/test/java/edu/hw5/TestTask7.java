package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask7 {
    @Test
    public void testTask7() {
        // Правильные строки
        assertTrue(Task7.task7("000"));
        assertTrue(Task7.task7("010"));
        assertTrue(Task7.task7("101"));
        assertTrue(Task7.task7("00"));
        assertTrue(Task7.task7("11"));
        assertTrue(Task7.task7("0"));
        assertTrue(Task7.task7("1"));
        // Неправильные строки
        assertFalse(Task7.task7("001000001"));
        assertFalse(Task7.task7(""));
        assertTrue(Task7.task7("0101"));
        assertTrue(Task7.task7("0010"));
    }
}
