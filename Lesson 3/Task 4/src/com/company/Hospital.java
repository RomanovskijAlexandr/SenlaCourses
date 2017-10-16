package com.company;

public class Hospital implements IHospital {
    private Doctor[] doctors;

    public Hospital() {
        this.doctors = new Doctor[3];
    }

    @Override
    public int getNumOfPatientsInHospital() {
        return Patient.countPatients;
    }

    @Override
    public int getNumOfDoctorInHospital() {
        return Doctor.countDoctors;
    }

    @Override
    public int getNumOfDoctorPatients(Doctor doctor) {
        int nullPatientCount = 0;
        System.out.println(doctor.getName() + " has patients: ");
        for (Patient patient:doctor.getPatients()) {
            if (patient==null)
                nullPatientCount++;
        }
        return doctor.getPatients().length - nullPatientCount;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors){
        this.doctors = doctors;
    }
}
