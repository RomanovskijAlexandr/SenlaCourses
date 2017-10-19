package com.company;

public class Doctor extends APerson {
    private Patient[] patients;

    public Doctor(String name) {
        super(name);
        System.out.println("create doctor");
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public void setPatient(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append("Patient with id: ").append(patient.getId())
                .append(" is registered to a doctor: ").append(this.getName()));
        if (new PlacesForPersons().checkPlacesForPerson(this.patients))
            this.patients[new PlacesForPersons().getFreePosition(this.patients)] = patient;
    }


    @Override
    public String toString() {
        return "Doctor name " + getName();
    }
}
