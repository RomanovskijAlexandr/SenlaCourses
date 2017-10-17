package com.company;

public class Bouquet implements IBouquet {
    @Override
    public void getPriceBouquet(AFlower[] flowers) {
        Double price = 0.0;

        for (AFlower flower:flowers) {
           price += flower.getPrice();
        }
        System.out.println("Bouquet consist of ");
        for (AFlower flower:flowers) {
            System.out.println(flower.toString());
        }
        System.out.println("Price of boquet is " + price);
    }
}
