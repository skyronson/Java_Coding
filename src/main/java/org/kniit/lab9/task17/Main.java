package org.kniit.lab9.task17;

public class Main {
    public static void main(String[] args) {
        User user = new User(null, "LongUsernameHere", 16, 150);

        try {
            System.out.println();
            Validator.validate(user);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
