package com.company;

public interface IRegistry {
    public void addPatientsToDoctor(Patient patient, Doctor doctor);
    public void removeOfDoctorPatients(Patient patient, Doctor doctor);
    public void addNewPatient(Patient patient);
    public void getNumOfPatients();
}
