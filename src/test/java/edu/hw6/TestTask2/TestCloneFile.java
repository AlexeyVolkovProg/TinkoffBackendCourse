package edu.hw6.TestTask2;

import edu.hw6.Task2.CloneFile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCloneFile {
    private static Path parentPath;
    @BeforeAll
    public static void setUp() {
        parentPath = Path.of("src", "test", "java", "edu", "hw6", "TestTask2", "test.txt");
    }

    @AfterAll
    public static void afterAll() {
        List<String> postfixes = List.of("", " (2)");
        Path parentPath1 = Path.of("src", "test", "java", "edu", "hw6", "TestTask2", "test — копия");
        postfixes.forEach(postfix -> parentPath1.resolve(postfix + ".txt").toFile().delete());
    }
    @Test
    public void testCloneFile() throws Exception {
        Path filePath = Paths.get(parentPath.toUri());
        System.out.println(filePath);
        assertTrue(CloneFile.cloneFile(filePath));
        assertTrue(Files.exists(filePath.resolveSibling("test — копия.txt")));
        assertTrue(CloneFile.cloneFile(filePath));
        assertTrue(Files.exists(filePath.resolveSibling("test — копия (2).txt")));
    }

    @Test
    public void testCloneFileNonExistentFile() {
        Path filePath = Paths.get("non_existent_file_path");
        assertFalse(CloneFile.cloneFile(filePath));
    }
}
