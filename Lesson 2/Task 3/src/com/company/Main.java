package com.company;

public class Main {

    public static void main(String[] args) {
        AssemblyLine assemblyLine = new AssemblyLine();
        Car car = new Car();
        assemblyLine.assembleProduct(car);
        System.out.println(car.toString());
    }
}
