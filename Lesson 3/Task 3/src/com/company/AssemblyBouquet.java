package com.company;

public class AssemblyBouquet implements IAssemblyBouquet {
    @Override
    public void assemblybouquet(AFlower[] flowers, AFlower flower) {
        if(new CheckBouquet().checkBouquetForFlowers(flowers))
            flowers[new CheckBouquet().getPositionInBouquet(flowers)] = flower;
    }
}
