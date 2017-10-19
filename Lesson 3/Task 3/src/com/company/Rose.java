package com.company;

public class Rose extends AFlower {

    public Rose(Double price) {
        super(price);
        System.out.println("Create Rose");
    }

    @Override
    public String toString() {
        return "Rose price is " + getPrice();
    }
}
