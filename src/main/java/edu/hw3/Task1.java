package edu.hw3;


/**
 * Шифр Атбаша - это метод шифрования, при котором каждая буква слова заменяется на свою
 * "зеркальную" букву в алфавите: A <=> Z; B <=> Y; C <=> X и т.д.
 * Создайте функцию, которая принимает строку и применяет к ней шифр.
 * Замечания:
 * используется латинский алфавит
 * регистр букв нужно сохранить
 * символы не латинского алфавита нужно писать как есть
 */
public class Task1 {

    private Task1() {

    }

    public static String atbashEncrypt(String processedString) {
        StringBuilder result = new StringBuilder();
        for (char c : processedString.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (base + ('Z' - Character.toUpperCase(c))));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
