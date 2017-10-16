package com.company;

public class Lilak extends AFlower implements IBoquetPart{
    private Double length;

    public Lilak(Double price) {
        super(price);
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Lilak price is " + getPrice() ;
    }
}
