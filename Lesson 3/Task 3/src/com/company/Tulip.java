package com.company;

public class Tulip extends AFlower {

    public Tulip(Double price) {
        super(price);
        System.out.println("Create Tulip");
    }

    @Override
    public String toString() {
        return "Tulip price is " + getPrice();
    }
}
