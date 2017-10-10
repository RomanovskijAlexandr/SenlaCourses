package com.company;

public class BodyOfCarLineStep implements ILineStep {

    BodyOfCar bodyOfCar = new BodyOfCar("BROWN");

    public BodyOfCarLineStep(){
    }

    @Override
    public IProductPart buildProductPart() {
        return this.bodyOfCar;
    }
}
