package com.company;

public class BodyworkLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Bodywork("BROWN");
    }
}
