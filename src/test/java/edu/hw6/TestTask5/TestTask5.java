package edu.hw6.TestTask5;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestTask5 {
    @Test
    public void assertThatHackerNewsTopStoriesWorksRight() {
        final int expectedLength = 500;
        assertEquals(expectedLength, HackerNews.hackerNewsTopStories().length);
    }

    @Test
    public void assertThatNewsWorksRight() {
        final String expected1 = "JDK 21 Release Notes";
        final String expected2 = "Google admits cracking down on people using ad blockers";
        assertEquals(expected1, HackerNews.news(37570037));
        assertEquals(expected2, HackerNews.news(38406979));
    }

    @Test
    public void assertThatNewsReturnedNullOnNonExistsId() {
        assertEquals("", HackerNews.news(Long.MAX_VALUE));
    }
}

