package org.kniit.lab10.task23;

public class Main {
    
    public static void printType(Object obj) {
        if (obj == null) {
            System.out.println("null");
        } else {
            System.out.println(obj.getClass().getName());
        }
    }
    
    // Пример использования
    public static void main(String[] args) {
        printType(123);        // java.lang.Integer
        printType("Hello");    // java.lang.String
        printType(3.14);       // java.lang.Double
        printType('A');        // java.lang.Character
        printType(null);       // null
    }
}
