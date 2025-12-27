package com.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в систему управления пользователями!");
        System.out.println("Доступные команды: add, list, delete, update, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            
            List<String> parts = CommandParser.parseCommandLine(input);
            if (parts.isEmpty()) continue;
            String command = parts.get(0).toLowerCase();

            try {
                switch (command) {
                    case "add":
                        if (parts.size() != 3) {
                            System.out.println("Использование: add [name] [email]");
                            break;
                        }
                        userService.registerUser(parts.get(1), parts.get(2));
                        break;

                    case "list":
                        userService.listAllUsers();
                        break;

                    case "delete":
                        if (parts.size() != 2 || !isInteger(parts.get(1))) {
                            System.out.println("Использование: delete [id]");
                            break;
                        }
                        userService.deleteUser(Integer.parseInt(parts.get(1)));
                        break;

                    case "update":
                        if (parts.size() != 4 || !isInteger(parts.get(1))) {
                            System.out.println("Использование: update [id] [new_name] [new_email]");
                            break;
                        }
                        userService.updateUser(Integer.parseInt(parts.get(1)), parts.get(2), parts.get(3));
                        break;

                    case "exit":
                        System.out.println("Выход...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неизвестная команда. Доступные: add, list, delete, update, exit");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка ввода: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Ошибка базы данных: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}