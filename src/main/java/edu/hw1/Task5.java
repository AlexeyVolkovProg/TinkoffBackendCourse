package edu.hw1;

/**
 * Будем называть потомком числа новое число, которое создается путем суммирования каждой пары соседних цифр.
 * Например, число 123312 не является палиндромом, но его потомок 363 -- является:
 * 3 = 1 + 2
 * 6 = 3 + 3
 * 3 = 1 + 2
 * Напишите функцию, которая будет возвращать true,
 * если число является палиндромом или если любой из его потомков длиной > 1 (как минимум 2 цифры) является палиндромом.
 * Примеры:
 * isPalindromeDescendant(11211230) -> true // 11211230 -> 2333 -> 56 -> 11
 * isPalindromeDescendant(13001120) -> true // 13001120 -> 4022 ➞ 44
 * isPalindromeDescendant(23336014) -> true // 23336014 -> 5665
 * isPalindromeDescendant(11) -> true
 */
public class Task5 {
    private Task5() {

    }

    public static Boolean isPalindromeDescendant(int num) {
        String numStr = String.valueOf(num);
        // если нечетное кол-во цифр, смотрим является ли палиндромом, а потомков не рассматриваем
        if (numStr.length() % 2 != 0) {
            return checkPalindrome(numStr);
        } else if (checkPalindrome(numStr)) {
            return true;
        }
        // рекурсивная проверка потомков, потомки длиной 1 за палиндромы не считаем
        if (createNumber(numStr).length() == 1) {
            return false;
        } else {
            return isPalindromeDescendant(Integer.parseInt(createNumber(numStr)));
        }
    }

    public static Boolean checkPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static String createNumber(String string) {
        StringBuilder newNumString = new StringBuilder();

        for (int i = 0; i < string.length(); i += 2) {
            int digit1 = Character.getNumericValue(string.charAt(i));
            int digit2 = Character.getNumericValue(string.charAt(i + 1));
            int sum = digit1 + digit2;
            newNumString.append(sum);
        }
        return newNumString.toString();
    }

}
