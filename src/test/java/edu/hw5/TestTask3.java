package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestTask3 {
    @Test
    public void testParseDate() {
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)), Task3.parseDate("2020-10-10"));
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)), Task3.parseDate("2020-12-2"));
        assertEquals(Optional.of(LocalDate.of(1976, 3, 1)), Task3.parseDate("1/3/1976"));
        assertEquals(Optional.of(LocalDate.of(2020, 3, 1)), Task3.parseDate("1/3/20"));
        assertEquals(Optional.of(LocalDate.now().plusDays(1)), Task3.parseDate("tomorrow"));
        assertEquals(Optional.of(LocalDate.now()), Task3.parseDate("today"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), Task3.parseDate("yesterday"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), Task3.parseDate("1 day ago"));
        assertEquals(Optional.of(LocalDate.now().minusDays(2234)), Task3.parseDate("2234 days ago"));
        assertFalse(Task3.parseDate("invalid").isPresent());
        assertFalse(Task3.parseDate("2020-32-01").isPresent());
        assertFalse(Task3.parseDate("2020-01-32").isPresent());
        assertFalse(Task3.parseDate("2020/01/01").isPresent());
        assertFalse(Task3.parseDate("2020-01-01T12:00:00").isPresent());
    }
}
