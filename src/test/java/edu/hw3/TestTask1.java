package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {
    @Test
    public void testAtbashEncrypt_withLowercaseLetters() {
        String input = "abc";
        String expectedOutput = "zyx";
        String result = Task1.atbashEncrypt(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testAtbashEncrypt_withUppercaseLetters() {
        String input = "XYZ";
        String expectedOutput = "CBA";
        String result = Task1.atbashEncrypt(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testAtbashEncrypt_withMixedCaseLetters() {
        String input = "AbC";
        String expectedOutput = "ZyX";
        String result = Task1.atbashEncrypt(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testAtbashEncrypt_withNonLetters() {
        String input = "123!@";
        String expectedOutput = "123!@";
        String result = Task1.atbashEncrypt(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testAtbashEncrypt_withEmptyString() {
        String input = "";
        String expectedOutput = "";
        String result = Task1.atbashEncrypt(input);
        assertEquals(expectedOutput, result);
    }
}
