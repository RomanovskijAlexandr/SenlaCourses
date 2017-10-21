package com.company;

public class Main {
    public static void main(String[] args) {

        int numOfPatients = 2;
        int numOfDoctrors = 2;
        int numOfDoctorPatients = 2;
        Registry registry = new Registry(numOfPatients);
        Hospital hospital = new Hospital(numOfDoctrors);

        Patient patient = new Patient("1", "Korn");
        Patient patient1 = new Patient("2", "Bob");
        registry.addNewPatient(patient);
        registry.addNewPatient(patient1);

        Doctor doctor = new Doctor("Doctor John", 2);
        Doctor doctor1 = new Doctor("Doctor Who", 2);
        hospital.addNewDoctor(doctor);
        hospital.addNewDoctor(doctor1);

        new Main().getHospitalInformation(hospital, registry);

        doctor.setPatient(patient);
        doctor.setPatient(patient1);
        System.out.println(hospital.getNumOfDoctorPatients(doctor));

        registry.removeOfDoctorPatient(patient, doctor);
        System.out.println(hospital.getNumOfDoctorPatients(doctor));

        registry.addPatientsToDoctor(patient, doctor);
    }

    private void getHospitalInformation(Hospital hospital, Registry registry) {
        System.out.println("Doctors in Hospital: ");
        hospital.printDoctors();
        System.out.println("Patients in registry: ");
        registry.printPatients();
        System.out.println(registry.getNumOfPatients());
        System.out.println(hospital.getNumOfDoctors());
    }
}
