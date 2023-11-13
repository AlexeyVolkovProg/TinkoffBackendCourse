package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask8 {
    @Test
    public void testTask81() {
        assertTrue(Task8Bonus.task81("1"));
        assertTrue(Task8Bonus.task81("010"));
        assertTrue(Task8Bonus.task81("1010101"));

        assertTrue(Task8Bonus.task81("0"));
        assertFalse(Task8Bonus.task81("00"));
        assertFalse(Task8Bonus.task81("1010"));
    }

    @Test
    public void testTask82() {
        assertTrue(Task8Bonus.task82("010"));
        assertTrue(Task8Bonus.task82("1010"));
        assertFalse(Task8Bonus.task82("01"));
        assertTrue(Task8Bonus.task82("10"));
        assertTrue(Task8Bonus.task82("0"));
        assertFalse(Task8Bonus.task82("1"));
        assertFalse(Task8Bonus.task82("101"));
        assertFalse(Task8Bonus.task82("0101"));
    }

    @Test
    public void testTask83() {
        assertTrue(Task8Bonus.task83("1"));
        assertTrue(Task8Bonus.task83("10101"));
        assertTrue(Task8Bonus.task83("101010101"));

        assertFalse(Task8Bonus.task83("0"));
        assertFalse(Task8Bonus.task83("010"));
        assertTrue(Task8Bonus.task83("10101010"));
    }

    @Test
    public void testTask84() {
        assertTrue(Task8Bonus.task84("0"));
        assertTrue(Task8Bonus.task84("1"));
        assertTrue(Task8Bonus.task84("1010"));
        assertTrue(Task8Bonus.task84("0101"));
        assertFalse(Task8Bonus.task84("11"));
        assertFalse(Task8Bonus.task84("111"));
    }
}
