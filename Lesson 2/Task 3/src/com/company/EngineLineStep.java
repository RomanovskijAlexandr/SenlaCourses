package com.company;

public class EngineLineStep implements ILineStep {

    Engine engine = new Engine(8);

    public EngineLineStep(){
    }

    @Override
    public IProductPart buildProductPart() {
        return this.engine;
    }
}
