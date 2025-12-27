package org.kniit.lab8.task13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagementSystem {
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in, "Cp866");

    public static void main(String[] args) {
        // Пытаемся загрузить пользователей при запуске
        try {
            users = UserManager.loadUsers();
            System.out.println("Данные загружены из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл с пользователями не найден. Начинаем с пустого списка.");
            users = new ArrayList<>();
        }

        System.out.println("Добро пожаловать в систему управления пользователями!");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("\nВведите номер действия: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1: addUser(); break;
                    case 2: showAllUsers(); break;
                    case 3: saveUsersToFile(); break;
                    case 4: loadUsersFromFile(); break;
                    case 5: {
                        // Сохраняем данные перед выходом
                        try {
                            UserManager.saveUsers(users);
                            System.out.println("Данные сохранены в файл.");
                        } catch (IOException e) {
                            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
                        }
                        running = false;
                        System.out.println("Программа завершена. До свидания!");
                    }
                    default: System.out.println("Неверный выбор. Попробуйте снова."); break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до 5.");
            }
        }
        
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Показать всех пользователей");
        System.out.println("3. Сохранить список пользователей в файл");
        System.out.println("4. Загрузить список пользователей из файла");
        System.out.println("5. Выйти");
    }

    private static void addUser() {
        String name;
        while (true) {
            System.out.print("\nВведите имя пользователя: ");
            name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым!");
            }
            else {
                break;
            }
        }
        
        int age = 0;
        while (true) {
            try {
                System.out.print("\nВведите возраст: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Возраст должен быть положительным числом");
                } 
                else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный возраст (целое число).");
            }
        }

        String email;
        while (true) {
            System.out.print("\nВведите email: ");
            email = scanner.nextLine().trim();
            
            if (email.isEmpty()) {
                System.out.println("Email не может быть пустым!");
            } else if (!isValidEmail(email)) {
                System.out.println("Неверный формат email. Пример: example@mail.com");
            } else {
                break;
            }
        }

        User newUser = new User(name, age, email);
        users.add(newUser);
        System.out.println("\nПользователь добавлен.");
    }

    private static boolean isValidEmail(String email) {
        // Простая проверка формата email
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private static void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
            return;
        }

        System.out.println("\nСписок пользователей:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
        System.out.println("Всего пользователей: " + users.size());
    }

    private static void saveUsersToFile() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void loadUsersFromFile() {
        try {
            users = UserManager.loadUsers();
            System.out.println("Список успешно загружен из файла.");
            System.out.println("Загружено пользователей: " + users.size());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
}
