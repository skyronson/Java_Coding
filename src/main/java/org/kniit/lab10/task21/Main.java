package org.kniit.lab10.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null || predicate == null) {
            throw new IllegalArgumentException("Список и предикат не должны быть null");
        }
        
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Пример использования
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]
    }
}
