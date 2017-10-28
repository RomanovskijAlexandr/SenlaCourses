package com.company;

public class ArrayHandler {
    public boolean checkArrayLength(APerson[] persons) {
        boolean flag = false;

        for (APerson person : persons) {
            if (person == null)
                flag = true;
        }

        if (!flag) {
            System.out.println("no available places");
            System.exit(0);
        }
        return flag;
    }

    public int getPosition(APerson[] persons) {
        int position = -1;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                position = i;
                break;
            }
        }
        return position;
    }

}
