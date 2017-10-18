package com.company;

public interface IHospital {
    public void getNumOfDoctors();
    public int getNumOfDoctorPatients(Doctor doctor);
    public void addNewDoctor(Doctor doctor);
}
