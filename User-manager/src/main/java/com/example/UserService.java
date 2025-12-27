package com.example;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Email уже существует: " + email);
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userDAO.create(user);
        System.out.println("Пользователь добавлен: " + user);
    }

    public void listAllUsers() throws SQLException {
        List<User> users = userDAO.findAll();
        if (users.isEmpty()) {
            System.out.println("Нет пользователей.");
        } else {
            users.forEach(System.out::println);
        }
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь с ID=" + id + " не найден.");
        }
        User user = userDAO.findById(id);
        userDAO.delete(id);
        System.out.printf("Пользователь \"%s\" (ID=%d) удалён.\n", user.getName(), id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User existing = userDAO.findById(id);
        if (existing == null) {
            throw new IllegalArgumentException("Пользователь с ID=" + id + " не найден.");
        }

        if (!existing.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new IllegalArgumentException("Email уже существует: " + newEmail);
        }

        existing.setName(newName);
        existing.setEmail(newEmail);
        userDAO.update(existing);
        System.out.println("Пользователь обновлён: " + existing);
    }
}