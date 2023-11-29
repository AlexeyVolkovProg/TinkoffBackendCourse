package edu.hw6.Task3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Predicates {
    private Predicates() {

    }

    /**
     * Метод позволяющий фильтровать файлы по размеру
     */
    public static boolean largerThan(Path entry, int bytes) {
        try {
            return Files.size(entry) > bytes;
        } catch (IOException ignored) {
            return false;
        }
    }

    /**
     * Фильтр при помощи glob-строк
     */
    public static boolean globMatches(Path entry, String glob) {
        return entry.getFileSystem()
            .getPathMatcher("glob:" + glob)
            .matches(entry.getFileName());
    }

    /**
     * Фильтрация при помощи регулярного выражения
     */
    public static boolean regexContains(Path entry, String regex) {
        return Pattern.compile("^.*" + regex + ".*$")
            .matcher(entry.getFileName().toString())
            .matches();
    }

    /**
     * Метод проверяющий на магические начальные идентификаторы
     */
    public static boolean magicNumber(Path entry, int... startIdentifiers) {
        try (DataInputStream in = new DataInputStream(new FileInputStream(entry.toFile()))) {
            byte[] bytes = in.readNBytes(startIdentifiers.length);
            for (int i = 0; i < bytes.length; i++) {
                if ((byte) startIdentifiers[i] != bytes[i]) {
                    return false;
                }
            }
            return true;
        } catch (IOException ignore) {
            return false;
        }
    }
}
