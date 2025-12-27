package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;


public class WordCounter {
    private static long totalWords = 0;
    private static int txtFilesCount = 0;
     public static void main(String[] args) {
        Path startPath = Paths.get("Java_Coding"); // начальная директория для обхода

        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
            System.out.println("Ошибка: указанный путь не существует или не является директорией!");
            return;
        }

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor());
            System.out.println("\nРЕЗУЛЬТАТЫ");
            System.out.println("Обработано текстовых файлов: " + txtFilesCount);
            System.out.println("Общее количество слов: " + totalWords);
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    private static class SimpleFileVisitor implements FileVisitor<Path> {
       @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("Каталог: " + dir.toAbsolutePath().toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().toLowerCase().endsWith(".txt")) {

                try {
                    long words = countWordsInFile(file);
                    System.out.println("\tФайл: " + file.getFileName() + " | Слов: " + words);
                    totalWords += words;
                    txtFilesCount += 1;
                } catch (IOException e) {
                    System.out.println("Не удалось прочитать файл: " + file.getFileName());
                }
            }
            
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.println("Завершение каталога: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }
    }

    private static long countWordsInFile(Path file) throws IOException {
        String line = Files.readString(file);
        line = line.trim();
        if (line.isEmpty()) {
            return 0;
        }
        String[] words = line.split("\\s+");
        return words.length;
    }
}
