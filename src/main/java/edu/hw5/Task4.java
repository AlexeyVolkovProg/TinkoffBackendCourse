package edu.hw5;

/**
 * Предположим, что в целях безопасности вы требуете, чтобы все пароли содержали хотя бы один из следующих символов
 * ~ ! @ # $ % ^ & * |
 * Напишите регулярное выражение, которое возвращает true тогда и только тогда,
 * когда пароль содержит один из требуемых символов.
 */
public class Task4 {
    private Task4() {

    }

    public static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
