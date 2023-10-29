package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Напишите функцию сортировки, которая принимает массив имен, сортирует их по фамилии
 * по возрастанию/убыванию (ASC/DESC) и возвращает новый массив контактов с заданной сортировкой.
 * Замечания:
 * если фамилия отсутствует, то нужно использовать имя
 * возвращать нужно не строки, а объекты
 * Примеры:
 * parseContacts([ "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" ], "ASC")
 * ->
 * [ "Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke" ]
 * // Aquinas (A) < Descartes (D) < Hume (H) < Locke (L)
 * parseContacts(["Paul Erdos", "Leonhard Euler", "Carl Gauss"], "DESC")
 * ->
 * ["Carl Gauss", "Leonhard Euler", "Paul Erdos"]
 * // Gauss (G) > Erdos (ER) > Euler (EU)
 * parseContacts([], "DESC") ➞ []
 * parseContacts(null, "DESC") ➞ []
 */
public class Task5 {

    private Task5() {

    }

    public List<Person> parsePersonList(String[] names, String order) {
        if (names == null || names.length == 0) {
            return Collections.emptyList();
        }

        List<Person> contacts = new ArrayList<>();
        for (String name : names) {
            contacts.add(new Person(name));
        }

        Comparator<Person> comparator = Comparator.comparing(Person::getLastName);
        if ("DESC".equals(order)) {
            comparator = comparator.reversed();
        }

        return contacts.stream()
            .sorted(comparator.thenComparing(Person::getFullName))
            .collect(Collectors.toList());
    }

    class Person {
        String fullName;

        Person(String fullName) {
            this.fullName = fullName;
        }

        public String getLastName() {
            String[] parts = fullName.split(" ");
            return parts.length > 1 ? parts[1] : parts[0];
        }

        @Override
        public String toString() {
            return fullName;
        }

        public String getFullName() {
            return fullName;
        }
    }

}
