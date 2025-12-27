package org.kniit.lab9.task17;

public class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    @Range(min = 1, max = 120)
    private int weight;

    public User(String name, String username, int age, int weight) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.weight = weight;
    }

    // Геттеры
    public String getName() { return name; }
    public String getUsername() { return username; }
    public int getAge() { return age; }
    public int getWeight() { return weight; }
}


class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}