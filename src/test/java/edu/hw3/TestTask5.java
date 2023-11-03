package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask5 {
    @Test
    public void testSortContactsASC() {
        Task5 task5 = new Task5();
        String[] input = { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" };
        List<Task5.Person> result = task5.parsePersonList(input, "ASC");
        assertEquals("Thomas Aquinas", result.get(0).getFullName());
        assertEquals("Rene Descartes", result.get(1).getFullName());
        assertEquals("David Hume", result.get(2).getFullName());
        assertEquals("John Locke", result.get(3).getFullName());
    }

    @Test
    public void testSortContactsDESC() {
        Task5 task5 = new Task5();
        String[] input = { "Paul Erdos", "Leonhard Euler", "Carl Gauss" };
        List<Task5.Person> result = task5.parsePersonList(input, "DESC");
        assertEquals("Carl Gauss", result.get(0).getFullName());
        assertEquals("Leonhard Euler", result.get(1).getFullName());
        assertEquals("Paul Erdos", result.get(2).getFullName());
    }

    @Test
    public void testSortContactsEmptyArray() {
        Task5 task5 = new Task5();
        String[] input = {};
        List<Task5.Person> result = task5.parsePersonList(input, "ASC");
        assertEquals(0, result.size());
    }

    @Test
    public void testSortContactsNullInput() {
        Task5 task5 = new Task5();
        String[] input = null;
        List<Task5.Person> result = task5.parsePersonList(input, "ASC");
        assertEquals(0, result.size());
    }

    @Test
    public void testSortContactsWithoutLastNames() {
        Task5 task5 = new Task5();
        String[] input = { "John", "Thomas", "David", "Rene" };
        List<Task5.Person> result = task5.parsePersonList(input, "ASC");
        assertEquals("David", result.get(0).getFullName());
        assertEquals("John", result.get(1).getFullName());
        assertEquals("Rene", result.get(2).getFullName());
        assertEquals("Thomas", result.get(3).getFullName());
    }
}
