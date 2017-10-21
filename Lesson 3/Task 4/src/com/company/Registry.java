package com.company;

public class Registry implements IRegistry {
    private Patient[] patients;

    public Registry(int n) {
        this.patients = new Patient[n];
    }

    public Patient[] getPatients() {
        return this.patients;
    }

    @Override
    public void addPatientsToDoctor(Patient patient, Doctor doctor) {
        doctor.setPatient(patient);
    }

    @Override
    public void addNewPatient(Patient patient) {
        if (new ArrayHandler().checkArrayLength(patients))
            patients[new ArrayHandler().getPosition(patients)] = patient;
    }

    @Override
    public void removeOfDoctorPatient(Patient patient, Doctor doctor) {
        System.out.println("remove patient with id: " + patient.getId());
        for (int i = 0; i < doctor.getPatients().length; i++) {
            if (patient == doctor.getPatients()[i]) {
                doctor.setPatient(null, i);
            }
        }
    }

    @Override
    public String getNumOfPatients() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    @Override
    public void printPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }
}
