package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Напишите функцию, которая определяет, что заданная строка S является подпоследовательностью другой строки T.
 * Например, abc является подпоследовательностью achfdbaabgabcaabg.
 * Решите задачу при помощи регулярных выражений.
 */

public class Task6 {
    private Task6() {

    }

    public static boolean isSubsequence(String s, String t) {
        Pattern pattern = Pattern.compile(".*" + s + ".*");
        Matcher matcher = pattern.matcher(t);
        return matcher.matches();
    }
}
