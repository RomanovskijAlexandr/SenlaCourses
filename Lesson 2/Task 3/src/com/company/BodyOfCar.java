package com.company;

public class BodyOfCar extends CarPart implements IProductPart {
    private String color;

    public BodyOfCar(String color) {
        this.color = color;
        System.out.println("Create Body of car");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "body of car has a color: " + color;
    }
}
