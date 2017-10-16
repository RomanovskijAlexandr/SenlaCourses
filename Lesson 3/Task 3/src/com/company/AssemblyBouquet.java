package com.company;

public class AssemblyBouquet implements IAssemblyBouquet {
    @Override
    public AFlower[] assemblyboquet(AFlower[] buquet) {
        buquet[0] = (AFlower) new LilakBuildStep().createBoquetPart();
        buquet[1] = (AFlower) new RoseBuildStep().createBoquetPart();
        buquet[2] = (AFlower) new TulipBuildStep().createBoquetPart();
        buquet[3] = (AFlower) new LilakBuildStep().createBoquetPart();
        buquet[4] = (AFlower) new RoseBuildStep().createBoquetPart();
        buquet[5] = (AFlower) new RoseBuildStep().createBoquetPart();
        buquet[6] = (AFlower) new TulipBuildStep().createBoquetPart();

        System.out.println("Create bouquet");

        return buquet;
    }
}
