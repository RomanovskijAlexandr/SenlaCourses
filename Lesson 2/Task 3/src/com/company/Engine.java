package com.company;

public class Engine extends CarPart implements IProductPart{
    private Integer numOfCylinder;

    public Engine(Integer numOfCylinder) {
        this.numOfCylinder = numOfCylinder;
        System.out.println("Create Engine");
    }

    public Integer getNumOfCylinder() {
        return numOfCylinder;
    }

    public void setNumOfCylinder(Integer numOfCylinder) {
        this.numOfCylinder = numOfCylinder;
    }
}
