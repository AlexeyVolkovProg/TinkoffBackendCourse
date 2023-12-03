package edu.hw7.Task2;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * Реализуйте функцию, которая вычисляет факториал числа в многопоточном режиме при помощи parallelStream.
 */
public class ParallelCalculateFactorial {
    private ParallelCalculateFactorial() {

    }

    public static BigInteger calculateFactorial(int n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
