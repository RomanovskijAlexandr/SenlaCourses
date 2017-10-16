package com.company;

public class ArrayHandler implements IArrayHandler {

    public ArrayHandler(){
    }

    @Override
    public void parseArray(String[] strings){
        Integer integer = 0;
        for (String str:strings) {
            integer += Integer.parseInt(str);
        }
        System.out.println("Sum in array = " + integer.toString());
    }

    @Override
    public void arrayInformation(String[] strings){
        System.out.println("Array consist of:");
        for (String str:strings) {
            System.out.println(str);
        }
    }
}
