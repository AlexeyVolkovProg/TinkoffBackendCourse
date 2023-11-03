package edu.hw3;

import java.util.TreeMap;

/**
 * Создать функцию, которая принимает арабское число и преобразует его в римское.
 * Примеры:
 * convertToRoman(2) ➞ "II"
 * convertToRoman(12) ➞ "XII"
 * convertToRoman(16) ➞ "XVI"
 */
public class Task4 {

    private Task4() {

    }

    public static String convertToRoman(int num) {
        int num1 = num;
        final int MAX_VALUE = 3999;
        final int MIN_VALUE = 0;
        if (num1 <= MIN_VALUE || num1 > MAX_VALUE) {
            return "Invalid value!";
        }
        TreeMap<Integer, String> romanMap = new TreeMap<>();
        final int M = 1000;
        final int CM = 900;
        final int D = 500;
        final int CD = 400;
        final int C = 100;
        final int XC = 90;
        final int L = 50;
        final int XL = 40;
        final int X = 10;
        final int IX = 9;
        final int V = 5;
        final int IV = 4;
        final int I = 1;

        romanMap.put(M, "M");
        romanMap.put(CM, "CM");
        romanMap.put(D, "D");
        romanMap.put(CD, "CD");
        romanMap.put(C, "C");
        romanMap.put(XC, "XC");
        romanMap.put(L, "L");
        romanMap.put(XL, "XL");
        romanMap.put(X, "X");
        romanMap.put(IX, "IX");
        romanMap.put(V, "V");
        romanMap.put(IV, "IV");
        romanMap.put(I, "I");

        StringBuilder result = new StringBuilder();
        while (num1 > 0) {
            int key = romanMap.floorKey(num1);
            String romanSymbol = romanMap.get(key);
            result.append(romanSymbol);
            num1 -= key;
        }
        return result.toString();
    }
}
