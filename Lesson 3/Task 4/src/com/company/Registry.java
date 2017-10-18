package com.company;

public class Registry implements IRegistry {
    private Patient[] patients;

    public Registry(int n){
        this.patients = new Patient[n];
    }

    public Patient[] getPatients(){
        return this.patients;
    }

    @Override
    public void addPatientsToDoctor(Patient patient, Doctor doctor) {
        doctor.setPatient(patient);
    }

    @Override
    public void addNewPatient(Patient patient){
        if (new PlacesForPersons().checkPlacesForPerson(patients))
            patients[new PlacesForPersons().getFreePosition(patients)] = patient;
    }

   @Override
    public void removeOfDoctorPatients(Patient patient, Doctor doctor) {
        System.out.println("remove patient with id: " + patient.getId());
        Patient[] patientsDoctor =doctor.getPatients();
        for(int i = 0; i< patients.length; i++){
            if(patients[i].equals(patient)){
                patients[i]=null;
            }
        }
        doctor.setPatients(patients);
    }

    @Override
    public void getNumOfPatients(){
        System.out.println("Registry has: " + patients.length + " patients");
    }

    public String toString() {
        for (Patient patient:patients) {
            System.out.println(patient.toString());
        }
        return "";
    }
}
