package com.company;

public class Main {

    public static void main(String[] args) {
        AFlower[] flowers = new AFlower[7];
        AssemblyBouquet assemblyBouquet = new AssemblyBouquet();
        Boquet boquet = new Boquet();
        boquet.getPriceBoquet(assemblyBouquet.assemblyboquet(flowers));
    }
}
