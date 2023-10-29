package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringManager {
    @BeforeEach
    public void setUp() {
        StringManager.setCharCountMap(null);
        StringManager.setProcessedString(null);
    }

    @Test
    public void testCreateCharCountMap() {
        StringManager.setProcessedString("hello");
        StringManager.createCharCountMap();

        assertNotNull(StringManager.getCharCountMap());
        assertEquals(4, StringManager.getCharCountMap().size());
        assertEquals(1, StringManager.getCharCountMap().get('h'));
        assertEquals(1, StringManager.getCharCountMap().get('e'));
        assertEquals(2, StringManager.getCharCountMap().get('l'));
        assertEquals(1, StringManager.getCharCountMap().get('o'));
    }

    @Test
    public void testDecreaseCharCountFoundCharacter() {
        StringManager.setProcessedString("hello");
        StringManager.createCharCountMap();
        int result = StringManager.decreaseCharCount('l');
        assertEquals(1, result);
        assertEquals(0, StringManager.getCharCountMap().get('l'));
    }

    @Test
    public void testDecreaseCharCountAlreadyFoundCharacter() {
        StringManager.setProcessedString("hello");
        StringManager.createCharCountMap();
        StringManager.decreaseCharCount('l'); // Первый раз нашли 'l'
        int result = StringManager.decreaseCharCount('l'); // Повторно нашли 'l'
        assertEquals(0, result);
        assertEquals(0, StringManager.getCharCountMap().get('l'));
    }

    @Test
    public void testDecreaseCharCountNotFoundCharacter() {
        StringManager.setProcessedString("hello");
        StringManager.createCharCountMap();
        int result = StringManager.decreaseCharCount('x'); // Символ 'x' отсутствует
        assertEquals(-1, result);
    }


    @Test
    public void testIsSuccess() {
        StringManager.setProcessedString("hello");
        StringManager.createCharCountMap();

        assertFalse(StringManager.isSuccess());

        StringManager.decreaseCharCount('h');
        StringManager.decreaseCharCount('e');
        StringManager.decreaseCharCount('l');
        StringManager.decreaseCharCount('l');
        StringManager.decreaseCharCount('o');

        assertTrue(StringManager.isSuccess());
    }
}
