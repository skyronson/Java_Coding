package org.kniit.lab10.task22;

import java.util.HashMap;
import java.util.Map;

public class Dictionary<K, V> {
    private Map<K, V> data;
    
    public Dictionary() {
        this.data = new HashMap<>();
    }
    
    /**
     * Добавляет пару ключ-значение в словарь
     * @param key ключ
     * @param value значение
     */
    public void put(K key, V value) {
        data.put(key, value);
    }
    
    /**
     * Получает значение по ключу
     * @param key ключ
     * @return значение, связанное с ключом, или null если ключ не найден
     */
    public V get(K key) {
        return data.get(key);
    }
    
    /**
     * Удаляет элемент по ключу
     * @param key ключ
     * @return значение, которое было удалено, или null если ключ не найден
     */
    public V remove(K key) {
        return data.remove(key);
    }
    
    /**
     * Проверяет, содержит ли словарь указанный ключ
     * @param key ключ
     * @return true если ключ существует, иначе false
     */
    public boolean containsKey(K key) {
        return data.containsKey(key);
    }
    
    /**
     * Возвращает количество элементов в словаре
     * @return размер словаря
     */
    public int size() {
        return data.size();
    }
    
    /**
     * Проверяет, пуст ли словарь
     * @return true если словарь пуст, иначе false
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
