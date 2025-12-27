package org.kniit.lab5.task8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Массив с именами товарных позиций
        String[] names = {"книга", "ручка", "линейка", "пинал"};
        Random random = new Random();
        
        ShopItem[] items = new ShopItem[100];

        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(names.length);
            items[i] = new ShopItem(names[index]);
        }
        
        // Сортируем массив по цене по возрастанию
        Arrays.sort(items, new Comparator<ShopItem>() {
            @Override
            public int compare(ShopItem item1, ShopItem item2) {
                return Double.compare(item1.getPrice(), item2.getPrice());
            }
        });

        System.out.println("Отсортированный список товаров:");
        for (ShopItem item : items) {
            System.out.println(item);
        }
        
        // Подсчитываем количество одинаковых ShopItem
        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }
        
        // Выводим одинаковые объекты
        System.out.println("\nОдинаковые товары:");
        int totalDuplicates = 0;
        for (Map.Entry<ShopItem, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - повторений: " + entry.getValue());
                totalDuplicates += entry.getValue() - 1;
            }
        }
        
        System.out.println("\nОбщее количество дубликатов: " + totalDuplicates);
        System.out.println("Уникальных товаров: " + itemCount.size());
    }
}