package com.company;

public class Hospital implements IHospital {
    private Doctor[] doctors;

    public Hospital(int n) {
        this.doctors = new Doctor[n];
    }

    @Override
    public int getNumOfDoctorPatients(Doctor doctor) {
        int nullPatientCount = 0;
        System.out.println("\n");
        System.out.print(doctor.getName() + " has patients: ");
        for (Patient patient:doctor.getPatients()) {
            if (patient==null)
                nullPatientCount++;
        }
        return doctor.getPatients().length - nullPatientCount;
    }

    @Override
    public void getNumOfDoctors(){
        System.out.println("Hospital has: " + doctors.length + " doctors");
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors){
        this.doctors = doctors;
    }

    @Override
    public void addNewDoctor(Doctor doctor){
        if (new PlacesForPersons().checkPlacesForPerson(doctors))
            doctors[new PlacesForPersons().getFreePosition(doctors)] = doctor;
    }

    @Override
    public String toString() {
        for (Doctor doctor:doctors) {
            System.out.println(doctor.toString());
        }
        return "";
    }
}
