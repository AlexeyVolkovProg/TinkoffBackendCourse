package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    public void testClusterizeSingleCluster() {
        String input = "(abc)";
        List<String> result = Task2.clusterize(input);
        assertEquals("(abc)", result.get(0));
    }

    @Test
    public void testClusterizeNestedClusters() {
        String input = "(abc(def)ghi)";
        List<String> result = Task2.clusterize(input);
        assertEquals("(abc(def)ghi)", result.get(0));
    }

    @Test
    public void testClusterizeEmptyString() {
        String input = "";
        List<String> result = Task2.clusterize(input);
        assertEquals(0, result.size());
    }


    @Test
    public void testClusterizeMultipleClusters() {
        String input = "abc(def)ghi(jkl(mno)pqr)";
        List<String> result = Task2.clusterize(input);
        assertEquals("(def)", result.get(0));
        assertEquals("(jkl(mno)pqr)", result.get(1));
    }
}
