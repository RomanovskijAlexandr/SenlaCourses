package com.company;

public class Hospital implements IHospital {
    private Doctor[] doctors;

    public Hospital(int n) {
        this.doctors = new Doctor[n];
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    @Override
    public void addNewDoctor(Doctor doctor) {
        if (new ArrayHandler().checkArrayLength(doctors))
            doctors[new ArrayHandler().getPosition(doctors)] = doctor;
    }

    @Override
    public int getNumOfDoctorPatients(Doctor doctor) {
        int nullPatientCount = 0;
        System.out.println("\n");
        System.out.print(doctor.getName() + " has patients: ");
        for (Patient patient : doctor.getPatients()) {
            if (patient == null)
                nullPatientCount++;
        }
        return doctor.getPatients().length - nullPatientCount;
    }

    @Override
    public String getNumOfDoctors() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    @Override
    public void printDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }
}