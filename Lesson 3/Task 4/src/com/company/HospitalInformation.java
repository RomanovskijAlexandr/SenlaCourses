package com.company;

public class HospitalInformation {
    public void getHospitalInformation(Hospital hospital, Registry registry) {
        System.out.println("Doctors in Hospital: ");
        System.out.println(hospital.printDoctors());
        System.out.println("Patients in registry: ");
        System.out.println(registry.printPatients());
        System.out.println(registry.getNumOfPatients());
        System.out.println(hospital.getNumOfDoctors());
    }
}
