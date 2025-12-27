package org.kniit.lab10.task18;

public class Main {
    public static void main(String[] args) {
        // Создание пары
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        
        // Получение значений
        System.out.println(pair.getFirst());  // Age
        System.out.println(pair.getSecond()); // 30
        
        // Изменение значения
        pair.setSecond(35);
        System.out.println(pair.getSecond()); // 35
        
        // Дополнительные примеры использования
        Pair<String, String> namePair = new Pair<>("FirstName", "John");
        Pair<Integer, Double> numberPair = new Pair<>(42, 3.14);
        
        System.out.println(namePair);    // Pair{FirstName, John}
        System.out.println(numberPair);  // Pair{42, 3.14}
    }
}
