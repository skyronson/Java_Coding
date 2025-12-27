package org.kniit.lab10.task18;

public class Pair<T, U> {
    private T first;
    private U second;

    // Конструктор
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Геттер для первого элемента
    public T getFirst() {
        return first;
    }

    // Сеттер для первого элемента
    public void setFirst(T first) {
        this.first = first;
    }

    // Геттер для второго элемента
    public U getSecond() {
        return second;
    }

    // Сеттер для второго элемента
    public void setSecond(U second) {
        this.second = second;
    }

    // Переопределим метод toString для удобства отладки
    @Override
    public String toString() {
        return "Pair{" + first + ", " + second + '}';
    }

    // Переопределим equals для корректного сравнения
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return (first != null ? first.equals(pair.first) : pair.first == null) &&
               (second != null ? second.equals(pair.second) : pair.second == null);
    }

    // Переопределим hashCode для соответствия equals
    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
