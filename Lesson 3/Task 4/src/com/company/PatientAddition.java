package com.company;

public class PatientAddition implements IAddition {
    private Patient[] patients = new Patient[3];

    @Override
    public Patient[] createPersons() {
        patients[0] = new Patient(); patients[0].setName("John");
        patients[1] = new Patient(); patients[1].setName("Alex");
        patients[2] = new Patient(); patients[2].setName("Carl");
        return patients;
    }
}
