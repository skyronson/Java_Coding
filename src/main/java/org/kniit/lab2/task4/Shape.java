package org.kniit.lab2.task4;

public abstract class Shape {
    public abstract double getVolume();
}


class Sphere extends Shape {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        double vol = 4/3 * Math.PI * Math.pow(radius, 3);
        return vol;
    }
}


class Cube extends Shape {
    double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        double vol = Math.pow(side, 3);
        return vol;
    }
}


class Cylinder extends Shape {
    double radius;
    double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double getVolume() {
        double vol = Math.PI * Math.pow(radius, 2) * height;
        return vol;
    }
}