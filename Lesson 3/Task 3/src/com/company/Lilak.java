package com.company;

public class Lilak extends AFlower implements IBouquetPart {

    public Lilak(Double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Lilak price is " + getPrice() ;
    }
}
