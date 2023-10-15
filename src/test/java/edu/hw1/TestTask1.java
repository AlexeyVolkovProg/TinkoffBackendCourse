package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {

    @Test
    @DisplayName("Test function minutesToSeconds on incorrect input data: invalid format")
    public void testInvalidFormat() {
        String firstTestString = "11:222";
        String secondTestString = "11:222:222";
        int result1 = Task1.minutesToSeconds(firstTestString);
        int result2 = Task1.minutesToSeconds(secondTestString);
        assertEquals(-1, result1); // Некорректный формат времени
        assertEquals(-1, result2); // Некорректный формат времени
    }

    @Test
    @DisplayName("Test function minutesToSeconds on incorrect input data: negative minutes and seconds")
    public void testNegativeMinutesAndSeconds() {
        String firstTestString = "-11:222";
        String secondTestString = "11:-222";
        int result1 = Task1.minutesToSeconds(firstTestString);
        int result2 = Task1.minutesToSeconds(secondTestString);
        assertEquals(-1, result1); // Отрицательные минуты
        assertEquals(-1, result2); // Отрицательные секунды
    }

    @Test
    @DisplayName("Test function minutesToSeconds on correct input data")
    public void testCorrectInputData(){
        String firstTestString = "2:00";
        String secondTestString = "2:15";
        int result1 = Task1.minutesToSeconds(firstTestString);
        int correctResult1 = 120;
        int result2 = Task1.minutesToSeconds(secondTestString);
        int correctResult2 = 135;
        assertEquals(correctResult1, result1); // Корректный результат
        assertEquals(correctResult2, result2); // Корректный результат
    }

}
