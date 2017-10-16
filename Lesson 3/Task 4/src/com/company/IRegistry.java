package com.company;

public interface IRegistry {
    public void addPacientsToDoctor(Patient[] patients, Doctor doctor);
    public void removeOfDoctorPacients(Patient patient, Doctor doctor);
}
