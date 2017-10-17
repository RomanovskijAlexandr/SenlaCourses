package com.company;

public class Tulip extends AFlower implements IBouquetPart {

    public Tulip(Double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Tulip price is " + getPrice() ;
    }
}
