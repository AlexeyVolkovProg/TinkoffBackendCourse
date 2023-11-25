package edu.hw6.TestTask3;

import edu.hw6.Task3.Predicates;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPredicates {
    private static final Path TEST_DATA_PATH = Path.of("src","test", "java", "edu", "hw6", "TestTask3", "data");

    @Test
    public void assertThatLargerThanWorksRight() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
        final List<String> expectedFileNames = List.of("img.png", "file_more_then_100_bytes.txt", "json1.json");
        final ArrayList<String> actualFileNames = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DATA_PATH)) {
            for (Path entry : entries) {
                if (Predicates.largerThan(entry, 100)) {
                    actualFileNames.add(entry.getFileName().toString());
                }
            }
        } catch (IOException ignored) {
        }
        assertEquals(expectedFileNames, actualFileNames);
    }

    @Test
    public void assertThatMagicNumberWorksRight() {
        final List<String> expectedFileNames = List.of("img.png");
        final ArrayList<String> actualFileNames = new ArrayList<>();

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DATA_PATH)) {
            for (Path entry : entries) {
                if (Predicates.magicNumber(entry, 0x89, 'P', 'N', 'G')) {
                    actualFileNames.add(entry.getFileName().toString());
                }
            }
        } catch (IOException ignored) {
        }
        assertEquals(expectedFileNames, actualFileNames);
    }

    @Test
    public void assertThatGlobMatchesWorksRight() {
        final List<String> expectedFileNames = List.of("json1.json");
        final ArrayList<String> actualFileNames = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DATA_PATH)) {
            for (Path entry : entries) {
                if (Predicates.globMatches(entry, "*.json")) {
                    actualFileNames.add(entry.getFileName().toString());
                }
            }
        } catch (IOException ignored) {
        }
        assertEquals(expectedFileNames, actualFileNames);
    }

    @Test
    public void assertThatRegexContainsWorksRight() {
        final List<String> expectedFileNames =
            List.of("file_less_than_100_bytes.txt", "file_more_then_100_bytes.txt");
        final ArrayList<String> actualFileNames = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_DATA_PATH)) {
            for (Path entry : entries) {
                if (Predicates.regexContains(entry, "100_bytes")) {
                    actualFileNames.add(entry.getFileName().toString());
                }
            }
        } catch (IOException ignored) {
        }
        assertEquals(expectedFileNames, actualFileNames);
    }
}
