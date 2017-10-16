package com.company;

public class DoctorAddition implements IAddition {

    private Doctor[] doctors = new Doctor[3];

    @Override
    public APerson[] createPersons() {
        doctors[0] = new Doctor(); doctors[0].setName("My first doctor");
        doctors[1] = new Doctor(); doctors[1].setName("My second doctor");
        doctors[2] = new Doctor(); doctors[2].setName("My third doctor");
        return doctors;
    }
}
