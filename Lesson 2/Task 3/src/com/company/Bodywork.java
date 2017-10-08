package com.company;

public class Bodywork extends CarPart implements IProductPart {
    private String color;

    public Bodywork(String color) {
        this.color = color;
        System.out.println("Create BodyWork");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
