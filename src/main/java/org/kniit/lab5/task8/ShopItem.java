package org.kniit.lab5.task8;

import java.util.Objects;
import java.util.Random;

public class ShopItem {
    public String name;
    public double price;
    public int quantity;

    public ShopItem(String name) {
        this.name = name;
        this.price = Math.round((Math.round((new Random().nextDouble() * 10 + 1) * 10.0) / 10.0 - 0.01) * 100.0) / 100.0;
        this.quantity = new Random().nextInt(10) + 1;
    }

    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Товар: %s, Цена: %s, Количество: %s", name, price, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        ShopItem item = (ShopItem) obj;
        return this.price == item.price &&
            this.quantity == item.quantity &&
            this.name == item.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }

}