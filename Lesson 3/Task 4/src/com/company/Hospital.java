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
        if (new PlacesForPersons().checkPlacesForPerson(doctors))
            doctors[new PlacesForPersons().getFreePosition(doctors)] = doctor;
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
    public StringBuilder getNumOfDoctors() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Hospital has: ").append(doctors.length).append(" doctors");
    }

    @Override
    public void printDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }
}
