package com.company;

public class Boquet implements IBoquete {
    @Override
    public void getPriceBoquet(AFlower[] boquet) {
        Double price = 0.0;

        for (AFlower flower:boquet) {
           price += flower.getPrice();
        }
        System.out.println("Boquet consist of ");
        for (AFlower flower:boquet) {
            System.out.println(flower.toString());
        }
        System.out.println("Price of boquet is " + price);
    }
}
