package edu.project1;

import java.util.HashMap;
import java.util.Map;
import static edu.project1.Session.logger;

public class StringManager {
    private static Map<Character, Integer> charCountMap;
    private static String processedString;

    private StringManager() {
    }

    /**
     * Создает словарь из символов и кол-ва их вхождения в обрабатываемую строку
     */
    public static Map<Character, Integer> createCharCountMap() {
        charCountMap = new HashMap<>();
        for (char c : processedString.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    /**
     * Проверяет символ и возвращает результат:
     * <p>
     * Возвращает 1, если пользователь нашел символ, который есть в строке.
     * Возвращает 0, если пользователь нашел символ, который уже ранее находил.
     * Возвращает -1, если данного символа не было в строке.
     *
     * @param character Символ, который нужно проверить в строке.
     * @return Результат проверки: 1, 0 или -1.
     */

    public static int decreaseCharCount(char character) {
        if (charCountMap.containsKey(character)) {
            int count = charCountMap.get(character);
            if (count >= 1) {
                charCountMap.put(character, 0);
                return 1;
            } else if (count == 0) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * Отвечает за вывод строки, все символы, которые не смог найти пользователь заменятся на "*"
     */
    public static void printProcessedString() {
        for (char c : processedString.toCharArray()) {
            if (charCountMap.containsKey(c) && (charCountMap.get(c) > 0)) {
                logger.info("*");
            } else {
                logger.info("[" + c + "]");
            }
        }
    }

    public static boolean isSuccess() {
        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void setProcessedString(String processedString) {
        StringManager.processedString = processedString;
    }

    public static Map<Character, Integer> getCharCountMap() {
        return charCountMap;
    }

    public static void setCharCountMap(Map<Character, Integer> charCountMap) {
        StringManager.charCountMap = charCountMap;
    }

    public static String getProcessedString() {
        return processedString;
    }
}

