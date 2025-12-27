package org.kniit.lab10.task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private List<T> items;
    
    public Box() {
        this.items = new ArrayList<>();
    }
    
    public void add(T item) {
        items.add(item);
    }
    
    // public double sum() {
    //     double total = 0.0;
    //     for (T item : items) {
    //         total += item.doubleValue();
    //     }
    //     return total;
    // }
}
