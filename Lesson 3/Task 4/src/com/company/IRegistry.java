package com.company;

public interface IRegistry {
    public void addPatientsToDoctor(Patient patient, Doctor doctor);

    public void removeOfDoctorPatient(Patient patient, Doctor doctor);

    public void addNewPatient(Patient patient);

    public String getNumOfPatients();

    public void printPatients();
}
