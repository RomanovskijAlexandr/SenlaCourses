package com.company;

public class ChasissLineStep implements ILineStep {

    Chassis chassis = new Chassis(10039.678);

    public ChasissLineStep(){
    }

    @Override
    public IProductPart buildProductPart() {
        return this.chassis;
    }
}
