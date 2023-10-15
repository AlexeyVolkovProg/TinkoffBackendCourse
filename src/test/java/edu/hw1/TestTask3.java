package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTask3 {

    @Test
    @DisplayName("Test function  isNestable on nestable arrays")
    public void testTrueNestable(){
        int[] firstArray1 = {2, 3, 4};
        int[] secondArray1 = {1, 5};
        int[] firstArray2 = {3,5,7};
        int[] secondArray2 = {9, 0};
        int[] firstArray3 = {3,50,70};
        int[] secondArray3 = {90, 0};
        assertThat(Task3.isNestable(firstArray1, secondArray1)).isTrue();
        assertThat(Task3.isNestable(firstArray2, secondArray2)).isTrue();
        assertThat(Task3.isNestable(firstArray3, secondArray3)).isTrue();
    }

    @Test
    @DisplayName("Test function isNestable on not nestable arrays")
    public void testFalseNestable(){
        int[] firstArray1 = {2, 3, 4};
        int[] secondArray1 = {1, 4};
        int[] firstArray2 = {3,5,7};
        int[] secondArray2 = {9, 7};
        int[] firstArray3 = {3,50,70};
        int[] secondArray3 = {90, 50};
        assertThat(Task3.isNestable(firstArray1, secondArray1)).isFalse();
        assertThat(Task3.isNestable(firstArray2, secondArray2)).isFalse();
        assertThat(Task3.isNestable(firstArray3, secondArray3)).isFalse();
    }

    @Test
    public void testIsNestableEmptyArray1() {
        int[] array1 = {};
        int[] array2 = {2, 3};
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(array1, array2));
    }

    @Test
    public void testIsNestableEmptyArray2() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {};
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(array1, array2));
    }





}
