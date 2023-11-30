package edu.hw7.Task4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Вычисление числа Pi, используя метод Монте-Карло и несколько потоков.
 */

@SuppressWarnings("MagicNumber")
public class PiCalc {
    private PiCalc() {

    }

    private static int getInsideCircle(int iterations, int insideCircle, Random random) {
        int insideCircle1 = insideCircle;
        for (int i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double distance = x * x + y * y;
            if (distance <= 1) {
                insideCircle1++;
            }
        }
        return insideCircle1;
    }

    public static double calculatePi(int iterations) {
        int insideCircle = 0;
        Random random = new Random();
        insideCircle = getInsideCircle(iterations, insideCircle, random);
        return (double) insideCircle / iterations * 4;
    }

    public static double calculatePiParallel(int iterations, int numThreads) {
        AtomicInteger insideCircle = new AtomicInteger(0);
        int iterationsPerThread = iterations / numThreads;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            executorService.execute(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                int localInsideCircle = 0;
                localInsideCircle = getInsideCircle(iterationsPerThread, localInsideCircle, random);
                insideCircle.addAndGet(localInsideCircle);
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        return (double) insideCircle.get() / iterations * 4;
    }

}
