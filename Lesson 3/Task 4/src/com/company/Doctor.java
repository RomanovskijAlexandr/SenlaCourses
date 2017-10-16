package com.company;

public class Doctor extends APerson {
    private Patient[] patients;
    static int countDoctors = 0;

    public Doctor() {
        this.patients = new Patient[3];
        countDoctors++;
        System.out.println("create doctor");
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor name " + getName();
    }
}
