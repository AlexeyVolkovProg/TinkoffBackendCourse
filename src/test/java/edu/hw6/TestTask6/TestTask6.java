package edu.hw6.TestTask6;

import edu.hw6.Task6.Task6;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw6.Task6.Task6.checkTcpPorts;
import static edu.hw6.Task6.Task6.checkUdpPorts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTask6 {
    @Test
    public void testCheckTcpPorts() {
        Task6 PortScanner = null;
        List<String> result = checkTcpPorts(1, 1024);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1024, result.size());
    }

    @Test
    public void testCheckUdpPorts() {
        Task6 PortScanner = null;
        List<String> result = checkUdpPorts(1, 1024);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1024, result.size());
    }

    @Test
    public void  testTcpApplicationPorts(){
        assertEquals("TCP:135:EPMAP", checkTcpPorts(135, 135).get(0));
        assertEquals("TCP:139:Служба сеансов NetBIOS", checkTcpPorts(139, 139).get(0));
        assertEquals("TCP:445:Microsoft-DS Active Directory", checkTcpPorts(445, 445).get(0));


    }

    @Test
    public void  testUdpApplicationPorts(){
        assertEquals("UDP:137:Служба имен NetBIOS", checkUdpPorts(137, 137).get(0));
        assertEquals("UDP:138:Служба датаграмм NetBIOS", checkUdpPorts(138, 138).get(0));
        assertEquals("UDP:5353:Многоадресный DNS", checkUdpPorts(5353, 5353).get(0));
    }
}
