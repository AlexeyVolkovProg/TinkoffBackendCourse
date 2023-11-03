package edu.hw3;

import edu.hw3.Task7.NullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

public class TestTask7 {
    @Test
    public void testComparatorForThreeMap(){
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());

        // Добавляем запись с ключом null
        tree.put(null, "test");

        // Проверяем, содержит ли TreeMap null
        boolean containsNull = tree.containsKey(null);
        System.out.println("Contains null: " + containsNull);
    }
}
