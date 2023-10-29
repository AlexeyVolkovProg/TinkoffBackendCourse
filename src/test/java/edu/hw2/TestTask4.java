package edu.hw2;

import edu.hw1.Task4;
import edu.hw2.Task4.CallingInfoExtractor;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task4.CallingInfoExtractor.callingInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTask4 {
    @Test
    public void testCallingInfo() {
        CallingInfoExtractor.CallingInfo callingInfo = callingInfo();
        assertNotNull(callingInfo);
        assertNotNull(callingInfo.className());
        assertNotNull(callingInfo.methodName());
    }

    @Test
    public void testCallingInfoContent() {
        CallingInfoExtractor.CallingInfo callingInfo = callingInfo();
        assertNotNull(callingInfo);
        assertEquals("edu.hw2.TestTask4", callingInfo.className());
        assertEquals("testCallingInfoContent", callingInfo.methodName());
    }
}

