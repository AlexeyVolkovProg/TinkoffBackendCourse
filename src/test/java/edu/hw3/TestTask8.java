package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestTask8 {
    @Test
    public void testBackwardIteratorForList(){
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1, 2, 3));
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }
    }
}
