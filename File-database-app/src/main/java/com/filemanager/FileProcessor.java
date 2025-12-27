package com.filemanager;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class FileProcessor {
    private final FileDAO fileDAO = new FileDAO();
    private static final long MAX_SIZE = 10 * 1024 * 1024; // 10 MB

    public void processPath(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("Путь не существует: " + path);
            return;
        }

        if (f.isFile()) {
            saveIfAllowed(f);
        } else if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        saveIfAllowed(file);
                    }
                }
            }
        }
    }

    private void saveIfAllowed(File file) {
        if (file.length() > MAX_SIZE) {
            System.out.println("Пропущен (>10 МБ): " + file.getName());
            return;
        }
        try {
            fileDAO.saveFile(file);
            System.out.println("Сохранён: " + file.getName());
        } catch (Exception e) {
            System.err.println("Ошибка: " + file.getName() + " — " + e.getMessage());
        }
    }

    public void listFiles() {
        try {
            List<FileInfo> files = fileDAO.listFiles();
            if (files.isEmpty()) {
                System.out.println("Нет сохранённых файлов.");
            } else {
                System.out.println("Сохранённые файлы:");
                files.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка БД при получении списка: " + e.getMessage());
        }
    }

    public void saveLocal(int id) {
        try {
            StoredFile stored = fileDAO.getFileById(id);
            if (stored == null) {
                System.out.println("Файл с ID=" + id + " не найден.");
                return;
            }

            String filename = stored.getFileName();
            // Защита от перезаписи — можно добавить префикс
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                fos.write(stored.getData());
            }
            System.out.println("Файл сохранён: " + filename);
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}