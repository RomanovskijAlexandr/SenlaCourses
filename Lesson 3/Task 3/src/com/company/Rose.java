package com.company;

public class Rose extends AFlower implements IBouquetPart {

    public Rose(Double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Rose price is " + getPrice() ;
    }
}
