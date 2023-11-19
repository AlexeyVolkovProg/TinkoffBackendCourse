package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {
    @Test
    public void testContainsSpecialCharacter() {
        assertTrue(Task4.containsSpecialCharacter("password~"));
        assertTrue(Task4.containsSpecialCharacter("pass!word"));
        assertTrue(Task4.containsSpecialCharacter("pa@ssword"));
        assertTrue(Task4.containsSpecialCharacter("pass#word"));
        assertTrue(Task4.containsSpecialCharacter("pa$ssword"));
        assertTrue(Task4.containsSpecialCharacter("pass%word"));
        assertTrue(Task4.containsSpecialCharacter("pass^word"));
        assertTrue(Task4.containsSpecialCharacter("pass&word"));
        assertTrue(Task4.containsSpecialCharacter("pass*word"));
        assertTrue(Task4.containsSpecialCharacter("pass|word"));
        assertFalse(Task4.containsSpecialCharacter("password"));
        assertFalse(Task4.containsSpecialCharacter("password123"));
        assertFalse(Task4.containsSpecialCharacter("paSSword"));
        assertFalse(Task4.containsSpecialCharacter("123456"));
        assertFalse(Task4.containsSpecialCharacter(""));
    }
}
