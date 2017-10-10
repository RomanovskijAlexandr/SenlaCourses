package com.company;

public class Car implements IProduct {

    private BodyOfCar bodyOfCar;
    private Chassis chassis;
    private Engine engine;

    public Car(){
        System.out.println("Create Car!");
    }

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        this.bodyOfCar = (BodyOfCar) firstProductPart;
        System.out.println("Install bodyOfCar");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        this.chassis = (Chassis) secondProductPart;
        System.out.println("Install chassis");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        this.engine = (Engine) thirdProductPart;
        System.out.println("Install engine");
    }

    public BodyOfCar getBodyOfCar() {
        return bodyOfCar;
    }

    public void setBodyOfCar(BodyOfCar bodyOfCar) {
        this.bodyOfCar = bodyOfCar;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        System.out.println("Car consist of:");
        return bodyOfCar.toString() + "\n" + chassis.toString() + "\n" + engine.toString();
    }
}
