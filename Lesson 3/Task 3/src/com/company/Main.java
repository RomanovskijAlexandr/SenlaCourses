package com.company;

public class Main {
    public static void main(String[] args) {
        int numFlowers = 5;

        Lilak lilak = (Lilak) new LilakBuildStep().createBoquetPart();
        Rose rose = (Rose) new RoseBuildStep().createBoquetPart();
        Tulip tulip = (Tulip) new TulipBuildStep().createBoquetPart();
        Lilak lilak1 = (Lilak) new LilakBuildStep().createBoquetPart();
        Rose rose1 = (Rose) new RoseBuildStep().createBoquetPart();
        Tulip tulip1 = (Tulip) new TulipBuildStep().createBoquetPart();

        AFlower[] flowers = new AFlower[numFlowers];
        AssemblyBouquet assemblyBouquet = new AssemblyBouquet();

        assemblyBouquet.assemblybouquet(flowers, lilak);
        assemblyBouquet.assemblybouquet(flowers, rose);
        assemblyBouquet.assemblybouquet(flowers, tulip);
        assemblyBouquet.assemblybouquet(flowers, lilak1);
        assemblyBouquet.assemblybouquet(flowers, rose1);

        //for check, if flowers more than places in bouquet
        //assemblyBouquet.assemblybouquet(flowers, tulip1);

        Bouquet bouquet = new Bouquet();

        bouquet.getPriceBouquet(flowers);
    }
}
