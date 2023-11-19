package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {

    @Test
    public void testAverageSessionDuration() {
        String input1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        String input2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";
        String[] inputs = {input1, input2};
        Duration totalDuration = Duration.ZERO;
        int sessionCount = 0;
        for (String input : inputs) {
            Duration sessionDuration = Task1.makeResults(input);
            totalDuration = totalDuration.plus(sessionDuration);
            sessionCount++;
        }
        Duration averageDuration = totalDuration.dividedBy(sessionCount);
        assertEquals(Duration.ofHours(3).plusMinutes(40), averageDuration);
    }

    @Test
    public void testMakeResults() {
        String input1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        Duration result = Task1.makeResults(input1);
        assertEquals(Duration.ofHours(3).plusMinutes(30), result);
    }

    @Test
    public void testFormatResult() {
        Duration duration = Duration.ofHours(3).plusMinutes(40);
        String result = Task1.formatResult(duration);
        assertEquals("3ч 40м", result);
    }
}
