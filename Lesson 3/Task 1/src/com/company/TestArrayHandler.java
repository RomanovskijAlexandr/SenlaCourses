package com.company;

public class TestArrayHandler{

    private  String[] strings;
    private ArrayHandler arrayHandler;

    public TestArrayHandler(){
        strings = new String[ 6 ];
        arrayHandler = new ArrayHandler();
    }

    public String[] setStrings(){
        strings[0] = "1";
        strings[1] = "0";
        strings[2] = "-2";
        strings[3] = "3";
        strings[4] = "4";
        strings[5] = "6";
        return strings;
    }

   public void checkArrayHandler(){
        setStrings();
       arrayHandler.parseArray(strings);
   }
}
