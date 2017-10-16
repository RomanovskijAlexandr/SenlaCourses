package com.company;

public class Tulip extends AFlower implements IBoquetPart{
    private Integer numOfPetals;

    public Tulip(Double price) {
        super(price);
    }

    public Integer getNumOfPetals() {
        return numOfPetals;
    }

    public void setNumOfPetals(Integer numOfPetals) {
        this.numOfPetals = numOfPetals;
    }

    @Override
    public String toString() {
        return "Tulip price is " + getPrice() ;
    }
}
