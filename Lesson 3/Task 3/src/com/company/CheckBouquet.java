package com.company;

public class CheckBouquet {
    public boolean checkBouquetForFlowers(AFlower[] flowers){
        boolean flag=false;
        for (AFlower flower:flowers) {
            if(flower == null)
                flag = true;
        }
        if (!flag){
            System.out.println("Bouquet don't have free places for flowers");
            System.exit(0);
        }
        return flag;
    }

    public int getPositionInBouquet(AFlower[] flowers){
        int position = -1;
        for (int i=0; i<flowers.length; i++) {
            if(flowers[i] == null){
                position = i;
                break;
            }
        }
        return position;
    }
}
