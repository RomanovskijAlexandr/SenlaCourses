package com.company;

public class AssemblyLine implements IAssemblyLine {

    public AssemblyLine(){
        assembleProduct(new Product());
    }

    @Override
    public IProduct assembleProduct(IProduct iProduct) {

        System.out.println("Start create product");

        Bodywork bodywork = (Bodywork) new BodyworkLineStep().buildProductPart();
        Chassis chassis = (Chassis) new ChasissLineStep().buildProductPart();
        Engine engine = (Engine) new EngineLineStep().buildProductPart();

        iProduct.installFirstPart(bodywork);
        iProduct.installSecondPart(chassis);
        iProduct.installThirdPart(engine);

        System.out.println("Create product success!!!");

        return iProduct;
    }
}
