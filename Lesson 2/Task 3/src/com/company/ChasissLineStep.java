package com.company;

public class ChasissLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Chassis(10054.78);
    }
}
