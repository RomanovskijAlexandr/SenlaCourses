package com.company;

public class TulipBuildStep implements IBuildStep {
    Tulip tulip = new Tulip(3.59);
    @Override
    public IBoquetPart createBoquetPart() {
        System.out.println("Add tulip in boquet");
        return this.tulip;
    }
}
