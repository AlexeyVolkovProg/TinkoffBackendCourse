package edu.hw7;

import edu.hw7.Task2.ParallelCalculateFactorial;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    void testCalculateFactorialForSmallNumber() {
        int number = 5;
        BigInteger expectedResult = BigInteger.valueOf(120);
        BigInteger result = ParallelCalculateFactorial.calculateFactorial(number);
        assertEquals(expectedResult, result);
    }

    @Test
    void testCalculateFactorialForLargeNumber() {
        int number = 20;
        BigInteger expectedResult = new BigInteger("2432902008176640000");
        BigInteger result = ParallelCalculateFactorial.calculateFactorial(number);
        assertEquals(expectedResult, result);
    }

    @Test
    void testCalculateFactorialForZero() {
        int number = 0;
        BigInteger expectedResult = BigInteger.ONE;
        BigInteger result = ParallelCalculateFactorial.calculateFactorial(number);
        assertEquals(expectedResult, result);
    }
}
