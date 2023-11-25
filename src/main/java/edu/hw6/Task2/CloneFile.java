package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task1.DiskManager.logger;

/**
 * Задание 2
 * При копировании файла в ту же папку в Проводнике Windows создается его копия, копия автоматически получает новое имя.
 * Воспроизведём это поведение.
 * Напишите функцию cloneFile(Path path), которая создает копию файла с новым именем.
 * Например, файл называется Tinkoff Bank Biggest Secret.txt.
 * Тогда новые имена файлов должны выглядеть следующим образом:
 * Tinkoff Bank Biggest Secret.txt
 * Tinkoff Bank Biggest Secret — копия.txt
 * Tinkoff Bank Biggest Secret — копия (2).txt
 * Tinkoff Bank Biggest Secret — копия (3).txt
 */
public class CloneFile {
    private CloneFile() {
    }

    public static boolean cloneFile(Path path) {
        try {
            String fileName = path.getFileName().toString();
            String fileExtension = "";
            int extensionIndex = fileName.lastIndexOf(".");
            if (extensionIndex != -1) {
                fileExtension = fileName.substring(extensionIndex);
                fileName = fileName.substring(0, extensionIndex);
            }
            Path newFilePath = path.resolveSibling(fileName + " — копия" + fileExtension);
            int copyNumber = 1;
            while (Files.exists(newFilePath)) {
                copyNumber++;
                newFilePath = path.resolveSibling(fileName + " — копия (" + copyNumber + ")" + fileExtension);
            }
            Files.copy(path, newFilePath);
            logger.info("Файл успешно скопирован: " + newFilePath);
            return true;
        } catch (IOException e) {
            logger.info("Ошибка при копировании файла: " + e.getMessage());
            return false;
        }
    }
}
