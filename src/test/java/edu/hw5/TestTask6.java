package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask6 {
    @Test
    public void testIsSubsequence() {
        assertTrue(Task6.isSubsequence("abc", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("abc", "abc"));
        assertTrue(Task6.isSubsequence("ab", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("aab", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("", "achfdbaabgabcaabg"));
        assertFalse(Task6.isSubsequence("xyz", "achfdbaabgabcaabg"));
        assertFalse(Task6.isSubsequence("abc", "ab"));
        assertFalse(Task6.isSubsequence("cba", "achfdbaabgabcaabg")); 
    }
}
