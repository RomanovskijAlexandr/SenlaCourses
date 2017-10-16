package com.company;

public class Registry implements IRegistry {
    private Patient[] patients;

    public Registry(){
        this.patients = new Patient[3];
    }
    @Override
    public void addPacientsToDoctor(Patient[] patients, Doctor doctor) {
        doctor.setPatients(patients);
    }

    @Override
    public void removeOfDoctorPacients(Patient patient, Doctor doctor) {
        System.out.println("remove patient " + patient.getName());
        patients =doctor.getPatients();
        for(int i = 0; i< patients.length; i++){
            if(patients[i].equals(patient)){
                patients[i]=null;
                Patient.countPatients --;
            }
        }
        doctor.setPatients(patients);
    }
}
