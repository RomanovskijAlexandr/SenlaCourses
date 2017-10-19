package com.company;

public class PlacesForPersons {
    public boolean checkPlacesForPerson(APerson[] persons) {
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

    public int getFreePosition(APerson[] persons) {
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
