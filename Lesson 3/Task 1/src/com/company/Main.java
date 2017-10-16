package com.company;

public class Main {

    public static void main(String[] args) {
       TestArrayHandler testArrayHandler = new TestArrayHandler();
       new ArrayHandler().arrayInformation(testArrayHandler.setStrings());
       testArrayHandler.checkArrayHandler();
    }
}
