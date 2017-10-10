package com.company;

public class AssemblyLine implements IAssemblyLine {

    public AssemblyLine(){
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        BodyOfCar bodyOfCar = (BodyOfCar) new BodyOfCarLineStep().buildProductPart();
        Chassis chassis = (Chassis) new ChasissLineStep().buildProductPart();
        Engine engine = (Engine) new EngineLineStep().buildProductPart();

        System.out.println("Start install parts for Car");

        product.installFirstPart(bodyOfCar);
        product.installSecondPart(chassis);
        product.installThirdPart(engine);

        System.out.println("Create product success!!!");

        return product;
    }
}
