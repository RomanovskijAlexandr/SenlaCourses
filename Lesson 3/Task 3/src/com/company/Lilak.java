package com.company;

public class Lilak extends AFlower {

    public Lilak(Double price) {
        super(price);
        System.out.println("Create Lilak");
    }

    @Override
    public String toString() {
        return "Lilak price is " + getPrice();
    }
}
