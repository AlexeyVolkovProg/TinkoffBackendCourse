package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGameDictionary {
    @BeforeEach
    public void setUp() {
        GameDictionary.getWordDictionary().clear();
    }

    @Test
    public void testAddWord() {
        GameDictionary.addWord("apple");
        Map<Integer, List<String>> dictionary = GameDictionary.getWordDictionary();
        assertTrue(dictionary.containsKey(5));
        List<String> words = dictionary.get(5);
        assertNotNull(words);
        assertTrue(words.contains("apple"));
    }

    @Test
    public void testGetRandomWord() {
        GameDictionary.addWord("apple");
        GameDictionary.addWord("banana");
        GameDictionary.addWord("carrot");

        String randomWord = GameDictionary.getRandomWord(6);
        assertNotNull(randomWord);
        assertTrue(randomWord.equals("banana") || randomWord.equals("carrot"));

        randomWord = GameDictionary.getRandomWord(7);
        assertNull(randomWord);
    }
}

