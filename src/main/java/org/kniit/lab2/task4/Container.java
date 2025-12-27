package org.kniit.lab2.task4;

import java.util.ArrayList;
import java.util.List;

public class Container {
    double volume;
    ArrayList<Shape> shapes;

    public Container(int vol) {
        this.volume = vol;
        this.shapes = new ArrayList<>();
    }

    public boolean add(Shape shape) {  
        double shapeVolume = shape.getVolume();
        if (this.volume >= shapeVolume) {
            shapes.add(shape);
            this.volume -= shapeVolume;
            return true;
        } 
        return false;
    }

     public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }
}
