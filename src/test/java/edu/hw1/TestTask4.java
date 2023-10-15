package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {

    @Test
    @DisplayName("Test function  fixString")
    public void testFixString(){
        String input1 = "оПомигети псаривьтс ртко!и";
        String expected1 = "Помогите исправить строки!";
        assertEquals(expected1, Task4.fixString(input1));
        String input2 = "";
        String expected2 = "";
        assertEquals(expected2, Task4.fixString(input2));
        String input3 = "badce";
        String expected3 = "abcde";
        assertEquals(expected3, Task4.fixString(input3));
        String input4 = "1a2b3c4";
        String expected4 = "a1b2c34";
        assertEquals(expected4, Task4.fixString(input4));

    }
}
