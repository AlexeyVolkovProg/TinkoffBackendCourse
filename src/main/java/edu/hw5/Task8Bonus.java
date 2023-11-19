package edu.hw5;

public class Task8Bonus {
    private Task8Bonus() {

    }

    /**
     * Нечетная длина строки
     */
    public static Boolean task81(String string) {
        return string.matches("^[01]([01][01])*$");
    }

    /**
     * Начинается с 0 и имеет нечетную длину или начинается с 1 и имеет четную длину
     */
    public static Boolean task82(String string) {
        return string.matches("(^0([01][01])*$)|(^1[01]([01][01])*$)");
    }

    /**
     * Каждый нечетный символ равен 1
     */
    public static boolean task83(String string) {
        return string.matches("(^1(01)*$|^(10)*$)");
    }

    /**
     * Любая строка, кроме 11 или 111
     */
    public static boolean task84(String string) {
        return string.matches("^(?!1{2,3}$)[01]*$");
    }

}
