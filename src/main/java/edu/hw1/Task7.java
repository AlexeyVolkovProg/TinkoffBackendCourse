package edu.hw1;

/**
 * Java есть базовые битовые операции, но нет циклического сдвига битов.
 * <p>
 * Напишите 2 функции:
 * <p>
 * int rotateLeft(int n, int shift)
 * int rotateRight(int n, int shift)
 * где
 * <p>
 * n -- целое число положительное число
 * shift -- размер циклического сдвига
 * Примеры:
 * <p>
 * rotateRight(8, 1) -> 4 // 1000 -> 0100
 * rotateLeft(16, 1) -> 1 // 10000 -> 00001
 * rotateLeft(17, 2) -> 6 // 10001 -> 00110  * rotateLeft(17, 2) -> 6 // 10001 -> 00110
 */
public class Task7 {

    private Task7() {

    }

    public static int rotateLeft(int n, int shift) {
        String string = Integer.toBinaryString(n);
        char[] bitArray = string.toCharArray();
        int length = bitArray.length;
        char[] rotated = new char[length];
        for (int i = 0; i < length; i++) {
            int newIndex = (i - shift + length) % length;
            rotated[newIndex] = bitArray[i];
        }
        String result1 = new String(rotated);
        return Integer.parseInt(result1, 2);
    }

    public static int rotateRight(int n, int shift) {
        String string = Integer.toBinaryString(n);
        char[] bitArray = string.toCharArray();
        int length = bitArray.length;
        char[] rotated = new char[length];
        for (int i = 0; i < length; i++) {
            int newIndex = (i + shift) % length;
            rotated[newIndex] = bitArray[i];
        }
        String result1 = new String(rotated);
        return Integer.parseInt(result1, 2);
    }

}
