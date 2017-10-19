package com.company;

public interface IHospital {
    public StringBuilder getNumOfDoctors();

    public int getNumOfDoctorPatients(Doctor doctor);

    public void addNewDoctor(Doctor doctor);

    public void printDoctors();
}
