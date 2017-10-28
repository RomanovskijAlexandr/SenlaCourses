package com.company;

public class Finder{
    private Number number;

    public Finder(){
        number = new Number();
    }

    public void findMaxNumeral() {
       number.setRandomValue();
       System.out.println("Random number is " + number.getValue().toString());
       Integer maxNum = number.getValue() % 10;
       for (int i = 0; i<3; i++){
           if(maxNum<number.getValue() %10){
               maxNum = number.getValue() %10;
           }
           number.setValue(number.getValue() / 10);
       }
        System.out.println("Max numeral is " + maxNum.toString());
    }
}
