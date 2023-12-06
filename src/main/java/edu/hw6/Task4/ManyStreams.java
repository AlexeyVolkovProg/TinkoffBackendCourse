package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;

/**
 * В этом задании мы будем делать композицию OutputStream'ов, стрелка -> указывает, кто куда пишет:
 * PrintWriter -> OutputStreamWriter -> BufferedOutputStream -> CheckedOutputStream -> file OutputStream.
 * При построении цепочек такого типа всегда следует начинать с самого нижнего уровня:
 * Создайте файл (Files.new*(...)) и получите из него OutputStream
 * Добавьте к нему CheckedOutputStream для проверки записи при помощи контрольной суммы
 * Для буферизации данных добавьте BufferedOutputStream
 * Чтобы не работать с сырыми байтами добавьте OutputStreamWriter, и включите поддержку UTF-8.
 * Добавьте финальный PrintWriter и запишите в файл текст:
 * Programming is learned by writing programs. ― Brian Kernighan
 * Не забудьте закрыть ресурсы с помощью try-with-resources.
 */
public class ManyStreams {
    private static final Checksum CRC32 = new CRC32(); // алгоритм подсчета контрольной суммы

    private ManyStreams() {

    }

    public static boolean writeStreams(Path path) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
            new BufferedOutputStream(new CheckedOutputStream(Files.newOutputStream(path), new CRC32())),
            StandardCharsets.UTF_8
        ))) {
            writer.write("Programming is learned by writing programs. ― Brian Kernighan");
            return true;
        } catch (IOException ignored) {
        }
        return false;
    }

}
