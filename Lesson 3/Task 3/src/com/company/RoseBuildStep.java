package com.company;

public class RoseBuildStep implements IBuildStep {
    Rose rose = new Rose(6.73);
    @Override
    public IBoquetPart createBoquetPart() {
        System.out.println("Add rose in boquet");
        return this.rose;
    }
}
