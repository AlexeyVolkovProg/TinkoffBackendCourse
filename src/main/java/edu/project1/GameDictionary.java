package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameDictionary {
    private static final Map<Integer, List<String>> WORD_DICTIONARY = new HashMap<>();

    private GameDictionary() {

    }

    static {
        addWord("apple");
        addWord("banana");
        addWord("carrot");
        addWord("house");
        addWord("table");
        addWord("laptop");
        addWord("guitar");
        addWord("flower");
        addWord("hello");
    }

    /**
     * Добавление элементов(слов) в наш словарь в соответствии с длиной
     */
    public static void addWord(String word) {
        int wordLength = word.length();
        if (!WORD_DICTIONARY.containsKey(wordLength)) {
            WORD_DICTIONARY.put(wordLength, new ArrayList<>());
        }
        WORD_DICTIONARY.get(wordLength).add(word);
    }

    /**
     * Получение случайного слова заданной длины
     */
    public static String getRandomWord(int length) {
        if (WORD_DICTIONARY.containsKey(length)) {
            List<String> words = WORD_DICTIONARY.get(length);
            if (!words.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(words.size());
                return words.get(randomIndex);
            }
        }
        return null;
    }

    public static Map<Integer, List<String>> getWordDictionary() {
        return WORD_DICTIONARY;
    }
}
