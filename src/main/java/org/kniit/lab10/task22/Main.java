package org.kniit.lab10.task22;

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println(dictionary.get("Alice")); // 25
        
        // Дополнительные примеры использования
        System.out.println(dictionary.size()); // 2
        System.out.println(dictionary.containsKey("Bob")); // true
        
        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice")); // null
        System.out.println(dictionary.size()); // 1
    }
}
