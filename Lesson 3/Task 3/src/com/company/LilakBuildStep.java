package com.company;

public class LilakBuildStep implements IBuildStep {
    Lilak lilak = new Lilak(4.34);
    @Override
    public IBoquetPart createBoquetPart() {
        System.out.println("Add lilak in boquet");
        return this.lilak;
    }
}
