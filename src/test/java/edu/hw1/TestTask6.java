package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTask6 {

    @Test
    @DisplayName("Test function on correct numbers")
    public void testOnCorrectNumbersCountK(){
        int number1 = 6621;
        int number2 = 6554;
        int number3 = 1234;
        int result1 = Task6.countK(number1);
        int correctResult1 = 5;
        int result2 = Task6.countK(number2);
        int correctResult2 = 4;
        int result3 = Task6.countK(number3);
        int correctResult3 = 3;
        assertEquals(correctResult1, result1);
        assertEquals(correctResult2, result2);
        assertEquals(correctResult3, result3);
    }

    @Test
    @DisplayName("Test function on no correct numbers")
    public void testOnNoCorrectNumbersCountK(){
        int number1 = 6666;
        int number2 = 999;
        int number3 = -1234;
        assertThrows(IllegalArgumentException.class, () -> {
            Task6.countK(number1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Task6.countK(number2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Task6.countK(number3);
        });
    }
}
