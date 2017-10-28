package com.company;

public class Doctor extends APerson {
    private Patient[] patients;

    public Doctor(String name, int numOfDoctorPatients) {
        super(name);
        this.patients = new Patient[numOfDoctorPatients];
        System.out.println("create doctor");
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatient(Patient patient, int position) {
        this.patients[position] = patient;
    }

    public void setPatient(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append("Patient with id: ").append(patient.getId())
                .append(" is registered to a doctor: ").append(this.getName()));
        if (new ArrayHandler().checkArrayLength(this.patients))
            this.patients[new ArrayHandler().getPosition(this.patients)] = patient;
    }


    @Override
    public String toString() {
        return "Doctor name " + getName();
    }
}
