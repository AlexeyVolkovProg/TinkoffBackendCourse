package edu.hw6.TestTask4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task4.ManyStreams.writeStreams;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {
    private static Path outputFilePath;

    @BeforeAll
    public static void setUp() {
        outputFilePath = Path.of("src\\test\\java\\edu\\hw6\\TestTask4\\output.txt");
    }

    @AfterAll
    public static void afterAll() {
        outputFilePath.toFile().delete();
    }

    @Test
    public void assertThatOutputFileContainsRightText() throws FileNotFoundException {
        assertTrue(writeStreams(outputFilePath));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(outputFilePath)))) {
            assertEquals("Programming is learned by writing programs. ― Brian Kernighan", reader.readLine());
        } catch (IOException ignored) {
        }
    }
}
