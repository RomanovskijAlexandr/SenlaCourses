package com.company;

public class Main {

    public static void main(String[] args) {
	AssemblyHospital assemblyHospital = new AssemblyHospital();
	Doctor[] doctors = assemblyHospital.createDoctorsPatients();
	assemblyHospital.getHospitalInfomation(doctors);
	assemblyHospital.testRemovePatient(doctors[0]);
    }
}
