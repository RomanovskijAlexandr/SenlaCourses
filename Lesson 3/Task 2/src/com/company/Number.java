package com.company;

import java.util.Random;

public class Number {
    private Integer value;
    private Random random;

    public Number() {
        random = new Random();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value){
        this.value = value;
    }

    public Integer setRandomValue(){
        value = 100 + random.nextInt(999 - 100);
        return value;
    }
}
