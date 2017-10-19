package com.company;

public class Main {
    public static void main(String[] args) {
        int numOfFlowers = 5;

        Lilak lilak = new Lilak(3.54);
        Rose rose = new Rose(4.26);
        Tulip tulip = new Tulip(2.78);
        Rose rose1 = new Rose(4.26);
        Tulip tulip1 = new Tulip(2.78);
        Bouquet bouquet = new Bouquet(numOfFlowers);

        bouquet.addFlowerInBouquet(lilak);
        bouquet.addFlowerInBouquet(rose);
        bouquet.addFlowerInBouquet(tulip);
        bouquet.addFlowerInBouquet(rose1);
        bouquet.addFlowerInBouquet(tulip1);

        //for check, if flowers more than places in bouquet
        //bouquet.addFlowerInBouquet(tulip1);

        bouquet.getPriceBouquet();
    }
}
