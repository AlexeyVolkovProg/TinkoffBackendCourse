package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {
    @Test
    public void testConvertToRomanValidInput() {
        assertEquals("I", Task4.convertToRoman(1));
        assertEquals("IV", Task4.convertToRoman(4));
        assertEquals("IX", Task4.convertToRoman(9));
        assertEquals("XII", Task4.convertToRoman(12));
        assertEquals("XXI", Task4.convertToRoman(21));
        assertEquals("XCIV", Task4.convertToRoman(94));
        assertEquals("C", Task4.convertToRoman(100));
        assertEquals("CD", Task4.convertToRoman(400));
        assertEquals("D", Task4.convertToRoman(500));
        assertEquals("CM", Task4.convertToRoman(900));
        assertEquals("MCMXCIV", Task4.convertToRoman(1994));
        assertEquals("MMXXIII", Task4.convertToRoman(2023));
        assertEquals("MMCMXCIX", Task4.convertToRoman(2999));
        assertEquals("MMMCMXCIX", Task4.convertToRoman(3999));
    }

    @Test
    public void testConvertToRomanInvalidInput() {
        assertEquals("Invalid value!", Task4.convertToRoman(0));
        assertEquals("Invalid value!", Task4.convertToRoman(-5));
        assertEquals("Invalid value!", Task4.convertToRoman(4000));
    }
}
