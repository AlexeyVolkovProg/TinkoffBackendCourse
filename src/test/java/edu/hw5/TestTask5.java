package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask5 {
    @Test
    public void testIsValidCarNumber() {
        assertTrue(Task5.isValidCarNumber("А123ВЕ777"));
        assertTrue(Task5.isValidCarNumber("О777ОО177"));
        assertFalse(Task5.isValidCarNumber("123АВЕ777"));
        assertFalse(Task5.isValidCarNumber("А123ВГ77"));
        assertFalse(Task5.isValidCarNumber("А123ВЕ7777"));
        assertTrue(Task5.isValidCarNumber("А123ВЕ77")); // Недостаточно цифр в середине
        assertFalse(Task5.isValidCarNumber("А123ВЕ7"));  // Недостаточно цифр в конце
        assertFalse(Task5.isValidCarNumber("А123ВЕ7!")); // Некорректный символ в конце
        assertFalse(Task5.isValidCarNumber("А123!ВЕ777")); // Некорректный символ в начале
        assertFalse(Task5.isValidCarNumber("А123ВЕ 777")); // Пробел в середине
    }
}
