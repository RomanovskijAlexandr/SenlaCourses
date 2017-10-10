package com.company;

public class Chassis extends CarPart implements IProductPart {
    private Double weight;

    public Chassis(Double weight) {
        this.weight = weight;
        System.out.println("Create Chasiss");
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Chassis's weight is " + weight;
    }
}
