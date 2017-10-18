package com.company;

public class Main {
    public static void main(String[] args) {

    int numOfPatients = 2;
    int numOfDoctrors = 2;
    Registry registry = new Registry(numOfPatients);
    Hospital hospital = new Hospital(numOfDoctrors);

    Patient patient = new Patient("1");
    Patient patient1 = new Patient("2");
    registry.addNewPatient(patient);
    registry.addNewPatient(patient1);

    Doctor doctor = new Doctor("Doctor John");
    Doctor doctor1 = new Doctor("Doctor Who");
    hospital.addNewDoctor(doctor);
    hospital.addNewDoctor(doctor1);

    HospitalInformation hospitalInformation = new HospitalInformation();
    hospitalInformation.getHospitalInformation(hospital, registry);

	doctor.setPatients(registry.getPatients());
	System.out.println(hospital.getNumOfDoctorPatients(doctor));

    registry.removeOfDoctorPatients(patient, doctor);
    System.out.println(hospital.getNumOfDoctorPatients(doctor));

    registry.addPatientsToDoctor(patient, doctor);
    }
}
