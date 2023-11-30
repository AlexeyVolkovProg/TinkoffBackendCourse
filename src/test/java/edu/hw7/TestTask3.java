package edu.hw7;

import edu.hw7.Task3.Database;
import edu.hw7.Task3.RealPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask3 {
    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @Test
    void testAddPerson() {
        RealPerson person = new RealPerson(1, "John", "123 Main St", "555-1234");
        database.add(person);
        List<RealPerson> foundByName = database.findByName("John");
        List<RealPerson> foundByAddress = database.findByAddress("123 Main St");
        List<RealPerson> foundByPhone = database.findByPhone("555-1234");
        assertEquals(1, foundByName.size());
        assertEquals(person, foundByName.get(0));
        assertEquals(1, foundByAddress.size());
        assertEquals(person, foundByAddress.get(0));
        assertEquals(1, foundByPhone.size());
        assertEquals(person, foundByPhone.get(0));
    }

    @Test
    void testDeletePerson() {
        RealPerson person = new RealPerson(1, "John", "123 Main St", "555-1234");
        database.add(person);
        database.delete(1);
        List<RealPerson> foundByName = database.findByName("John");
        List<RealPerson> foundByAddress = database.findByAddress("123 Main St");
        List<RealPerson> foundByPhone = database.findByPhone("555-1234");
        assertTrue(foundByName.isEmpty());
        assertTrue(foundByAddress.isEmpty());
        assertTrue(foundByPhone.isEmpty());
    }

    @Test
    void testFindNonexistentPerson() {
        List<RealPerson> foundByName = database.findByName("Nonexistent");
        List<RealPerson> foundByAddress = database.findByAddress("Nonexistent Address");
        List<RealPerson> foundByPhone = database.findByPhone("Nonexistent Phone");
        assertTrue(foundByName.isEmpty());
        assertTrue(foundByAddress.isEmpty());
        assertTrue(foundByPhone.isEmpty());
    }

    @Test
    void testAddPersonWithNullAttributes() {
        RealPerson person = new RealPerson(1, null, null, null);
        database.add(person);
        List<RealPerson> foundByName = database.findByName(null);
        List<RealPerson> foundByAddress = database.findByAddress(null);
        List<RealPerson> foundByPhone = database.findByPhone(null);
        assertTrue(foundByName.isEmpty());
        assertTrue(foundByAddress.isEmpty());
        assertTrue(foundByPhone.isEmpty());
    }
}
