package org.kniit.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.SortedSet;

public class StudentManager {
    private TreeSet<String> students;
    private Scanner scanner;

    public StudentManager() {
        students = new TreeSet<>();
        scanner = new Scanner(System.in, "Cp866");
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    findStudentsInRange();
                    break;
                case 6:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Найти студентов по диапазону (дополнительно)");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addStudent() {
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым!");
            return;
        }
        if (students.contains(name)) {
            System.out.println("Ошибка: студент с таким именем уже существует!");
        } 
        else {
            students.add(name);
            System.out.println("Студент добавлен.");
        }
    }

    private void removeStudent() {
        System.out.print("Введите имя студента для удаления: ");
        String name = scanner.nextLine().trim();
        
        if (students.remove(name)) {
            System.out.println("Студент удален.");
        } 
        else {
            System.out.println("Студент не найден в списке.");
        }
    }

    private void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }
        
        System.out.println("Список студентов:");
        int count = 1;
        for (String student : students) {
            System.out.println(count + ". " + student);
            count++;
        }
    }

    private void findStudent() {
        System.out.print("Введите имя студента для поиска: ");
        String name = scanner.nextLine().trim();
        
        if (students.contains(name)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент не найден.");
        }
    }

    private void findStudentsInRange() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }
        
        System.out.print("Введите первого студента из списка: ");
        String from = scanner.nextLine().trim();
        
        System.out.print("Введите последнего студента из списка: ");
        String to = scanner.nextLine().trim();
        
        // Используем subSet для получения диапазона
        TreeSet<String> range = new TreeSet<>(students.subSet(from, to + "\uFFFF"));
        
        if (range.isEmpty()) {
            System.out.println("В указанном диапазоне студентов не найдено.");
        } else {
            System.out.println("Список студентов в диапазоне от \"" + from + "\" до \"" + to + "\":");
            int count = 1;
            for (String student : range) {
                System.out.println(count + ". " + student);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.start();
    }
}
