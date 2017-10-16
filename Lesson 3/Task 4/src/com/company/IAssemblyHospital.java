package com.company;

public interface IAssemblyHospital {
    public Doctor[] createDoctorsPatients();
    public void getHospitalInfomation(Doctor[] doctors);
    public void testRemovePatient(Doctor doctor);
}
