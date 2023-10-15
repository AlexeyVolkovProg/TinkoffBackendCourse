package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask5 {

    @Test
    @DisplayName("Test function palindromeDescendant on odd len numbers")
    public void testPalindromeOddLenNumbers(){
        int number1 = 121;
        int number2 = 12121;
        int number3 = 22121;
        int number4 = 2212111;
        assertThat(Task5.isPalindromeDescendant(number1)).isTrue();
        assertThat(Task5.isPalindromeDescendant(number2)).isTrue();
        //для чисел нечетной длины потомки не рассматриваются, рассматривается только само начальное число
        assertThat(Task5.isPalindromeDescendant(number3)).isFalse();
        assertThat(Task5.isPalindromeDescendant(number4)).isFalse();
    }


    @Test
    @DisplayName("Test function palindromeDescendant on even len numbers")
    public void testPalindromeEvenLenNumbers(){
        int number1 = 11211230;
        int number2 = 13001120;
        int number3 = 23336014;
        int number4 = 12;
        assertThat(Task5.isPalindromeDescendant(number1)).isTrue(); // 11211230 -> 2333 -> 56 -> 11
        assertThat(Task5.isPalindromeDescendant(number2)).isTrue(); // 13001120 -> 4022 ➞ 44
        assertThat(Task5.isPalindromeDescendant(number3)).isTrue();// 23336014 -> 5665
        assertThat(Task5.isPalindromeDescendant(number4)).isFalse();// 12 -> 3, потомков, состоящих из 1-ой цифры мы не считаем за полиндром
    }



}
