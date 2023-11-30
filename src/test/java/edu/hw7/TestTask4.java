package edu.hw7;

import edu.hw7.Task4.PiCalc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {
    @Test
    public void testCalculatePi() {
        int iterations = 1000000;
        double result = PiCalc.calculatePi(iterations);
        assertTrue(result >= 0 && result <= 4, "Значение Pi должно быть между 0 и 4");
    }

    @Test
    public void testCalculatePiParallel() {
        int iterations = 1000000;
        int numThreads = 4;
        double result = PiCalc.calculatePiParallel(iterations, numThreads);
        assertTrue(result >= 0 && result <= 4, "Значение Pi должно быть между 0 и 4");
    }

    @Test
    public void testParallelPerformance() {
        int[] threadCounts = {1, 2, 4, 8};
        for (int numThreads : threadCounts) {
            long startTime = System.currentTimeMillis();
            int iterations = 1000000;
            PiCalc.calculatePiParallel(iterations, numThreads);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Потоки: " + numThreads + ", Время: " + elapsedTime + "мс");
        }
    }

    @Test
    public void testAccuracy() {
        int[] simulationCounts = {10000000, 100000000, 1000000000};
        for (int simulations : simulationCounts) {
            double sequentialResult = PiCalc.calculatePi(simulations);
            double parallelResult = PiCalc.calculatePiParallel(simulations, 12);
            double delta = 0.01;
            assertEquals(sequentialResult, parallelResult, delta,
                "Результат параллельного вычисления должен быть близким к последовательному для " + simulations +
                    " симуляций"
            );
        }
    }
}
