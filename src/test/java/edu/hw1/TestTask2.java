package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {

    @Test
    @DisplayName("Test function countingDigits")
    public void testCountingDigits(){
        int number1 = 12345;
        int number2 = -9876;
        int number3 = 0;
        int result1 = Task2.countingDigits(number1);
        int correctResult1 = 5;
        int result2 = Task2.countingDigits(number2);
        int correctResult2 = 4;
        int result3 = Task2.countingDigits(number3);
        int correctResult3 = 1;
        assertEquals(correctResult1, result1);
        assertEquals(correctResult2, result2);
        assertEquals(correctResult3, result3);
    }

}
