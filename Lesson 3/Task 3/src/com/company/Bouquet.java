package com.company;

public class Bouquet implements IBouquet {
    private AFlower[] flowers;

    public Bouquet(int numOfFlowers) {
        flowers = new AFlower[numOfFlowers];
    }

    @Override
    public void getPriceBouquet() {
        Double price = 0.0;

        for (AFlower flower : this.flowers) {
            price += flower.getPrice();
        }
        System.out.println("Bouquet consist of ");
        for (AFlower flower : this.flowers) {
            System.out.println(flower.toString());
        }
        System.out.println("Price of boquet is " + price);
    }

    @Override
    public void addFlowerInBouquet(AFlower flower) {
        if (new CheckBouquet().checkBouquetForFlowers(this.flowers))
            flowers[new CheckBouquet().getPositionInBouquet(this.flowers)] = flower;
        System.out.println("Add in bouquet " + flower.toString());
    }

}
