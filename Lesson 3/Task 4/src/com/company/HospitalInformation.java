package com.company;

public class HospitalInformation {
    public void getHospitalInformation(Hospital hospital, Registry registry){
        System.out.println("Doctors in Hospital: ");
        System.out.println(hospital.toString());
        System.out.println("Patients in registry: ");
        System.out.println(registry.toString());
        System.out.println("Number of patients in Hospital: " + registry.getPatients().length);
        System.out.println("Number of doctors in Hospital: " + hospital.getDoctors().length);
    }
}
