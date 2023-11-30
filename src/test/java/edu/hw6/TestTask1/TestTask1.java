package edu.hw6.TestTask1;

import edu.hw6.Task1.DiskManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask1 {

    @AfterEach
    public void afterEach() {
        Path path = Path.of("src", "main", "java", "edu", "hw6", "file2.txt");
        File file = new File(path.toUri());
        if (file.delete()) {
            System.out.println("Файл успешно удален.");
        } else {
            System.out.println("Не удалось удалить файл.");
        }
    }

    @Test
    public void testReadFromFile() throws IOException {
        Path path =  Path.of("src", "main", "java", "edu", "hw6", "file2.txt");
        DiskManager diskManager = new DiskManager(path.toString());
        assertTrue(diskManager.checkThePath(Paths.get(path.toUri())));
        diskManager.put("ключ1", "значение1");
        diskManager.put("ключ2", "значение2");
        diskManager.put("ключ3", "значение3");
        diskManager.loadToFile();
        assertEquals(3, diskManager.size());
        assertEquals("значение1", diskManager.get("ключ1"));
        assertEquals("значение2", diskManager.get("ключ2"));
        assertEquals("значение3", diskManager.get("ключ3"));
    }

    @Test
    public void testPutGet() throws IOException {
        Path path =  Path.of("src", "main", "java", "edu", "hw6", "file2.txt");
        DiskManager diskManager = new DiskManager(path.toString());
        diskManager.put("ключ1", "значение1");
        diskManager.put("ключ2", "значение2");
        diskManager.put("ключ3", "значение3");
        assertEquals("ключ1:значение1", "ключ1:" + diskManager.get("ключ1"));
        assertEquals("ключ2:значение2", "ключ2:" + diskManager.get("ключ2"));
        assertEquals("ключ3:значение3", "ключ3:" + diskManager.get("ключ3"));
    }

    @Test
    public void testIncorrectPath() throws IOException {
        Path path =  Path.of("src", "main", "java1", "edu", "hw6", "file2.txt");
        DiskManager diskManager = new DiskManager(path.toString());
        assertFalse(diskManager.checkThePath(Paths.get(path.toUri())));
    }
}
