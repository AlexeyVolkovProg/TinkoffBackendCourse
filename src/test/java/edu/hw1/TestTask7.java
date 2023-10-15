package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask7 {
    @Test
    public void testRotateRight() {
        assertEquals(4, Task7.rotateRight(8, 1)); // 1000 -> 0100
        assertEquals(1, Task7.rotateRight(16, 4)); // 10000 -> 00001
        assertEquals(17, Task7.rotateRight(17, 0));
        assertEquals(0, Task7.rotateRight(0, 5));
    }

    @Test
    public void testRotateLeft() {
        assertEquals(1, Task7.rotateLeft(8, 1)); // 1000 -> 0100
        assertEquals(1, Task7.rotateLeft(16, 1)); // 10000 -> 00001
        assertEquals(6,Task7.rotateLeft(17, 2)); // 10001 -> 00110
        assertEquals(17, Task7.rotateRight(17, 0));
        assertEquals(0, Task7.rotateRight(0, 5));
    }
}
