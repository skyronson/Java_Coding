package com.filemanager;

import java.util.Scanner;

public class FileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Cp1251");
        FileProcessor processor = new FileProcessor();

        System.out.println("Файловый менеджер - сохранение в PostgreSQL");
        System.out.println("Команды:");
        System.out.println("  save [путь]       - сохранить файл(ы) (<10 МБ)");
        System.out.println("  list              - показать список в БД");
        System.out.println("  saveLocal [id]    - скачать файл из БД");
        System.out.println("  exit              - выйти");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 3);
            String cmd = parts[0].toLowerCase();

            switch (cmd) {
                case "save":
                    if (parts.length < 2) {
                        System.out.println("Использование: save [путь]");
                    } else {
                        processor.processPath(parts[1]);
                    }
                    break;

                case "list":
                    processor.listFiles();
                    break;

                case "savelocal":
                    if (parts.length < 2 || !isInt(parts[1])) {
                        System.out.println("Использование: saveLocal [id]");
                    } else {
                        processor.saveLocal(Integer.parseInt(parts[1]));
                    }
                    break;

                case "exit":
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}