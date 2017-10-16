package com.company;

abstract class AFlower {
    private Double price;

    public AFlower(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
