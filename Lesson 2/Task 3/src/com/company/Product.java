package com.company;

public class Product implements IProduct {

    private Bodywork bodywork;
    private Chassis chassis;
    private Engine engine;

    public Product(Bodywork bodywork, Chassis chassis, Engine engine) {
        this.bodywork = bodywork;
        this.chassis = chassis;
        this.engine = engine;
        System.out.println("Create Product");
    }

    public Product(){}

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        System.out.println("Install first part!");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        System.out.println("Install second part!");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        System.out.println("Install third part!");
    }

    public Bodywork getBodywork() {
        return bodywork;
    }

    public void setBodywork(Bodywork bodywork) {
        this.bodywork = bodywork;
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
}
