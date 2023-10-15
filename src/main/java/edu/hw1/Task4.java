package edu.hw1;

/**
 * оПомигети псаривьтс ртко!и
 * Ой, имелось ввиду: "Помогите исправить строки!"
 * Все мои строки перепутались и каждая пара символов поменялась местами.
 * Напишите функцию, которая исправляет такие строки и возвращает правильный порядок.
 * Примеры:
 * fixString("123456") ➞ "214365"
 * fixString("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
 * fixString("badce") ➞ "abcde"
 */
public class Task4 {
    private Task4() {

    }

    public static String fixString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length() - 1; i += 2) {
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, stringBuilder.charAt(i + 1));
            stringBuilder.setCharAt(i + 1, temp);
        }
        return stringBuilder.toString();
    }
}
