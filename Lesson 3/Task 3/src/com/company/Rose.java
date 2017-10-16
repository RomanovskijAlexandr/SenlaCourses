package com.company;

public class Rose extends AFlower implements IBoquetPart{
    private String color;

    public Rose(Double price) {
        super(price);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rose price is " + getPrice() ;
    }
}
