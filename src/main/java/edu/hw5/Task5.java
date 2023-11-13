package edu.hw5;

/**
 * Напишите регулярное выражение для валидации российских номерных знаков.
 * Примеры правильных номерных знаков:
 * А123ВЕ777
 * О777ОО177
 * Примеры неправильных номерных знаков:
 * 123АВЕ777
 * А123ВГ77
 * А123ВЕ7777
 */
public class Task5 {
    private Task5() {

    }

    public static boolean isValidCarNumber(String carNumber) {
        String regex = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
        return carNumber.matches(regex);
    }
}
