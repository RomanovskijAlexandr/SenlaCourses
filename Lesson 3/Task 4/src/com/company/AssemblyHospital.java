package com.company;

public class AssemblyHospital implements IAssemblyHospital {

    @Override
    public Doctor[] createDoctorsPatients(){
        Doctor[] doctors = (Doctor[]) new DoctorAddition().createPersons();
        new Registry().addPacientsToDoctor(new PatientAddition().createPersons(), doctors[0]);
        new Registry().addPacientsToDoctor(new PatientAddition().createPersons(), doctors[1]);
        new Registry().addPacientsToDoctor(new PatientAddition().createPersons(), doctors[2]);
        return doctors;
    }

    @Override
    public void getHospitalInfomation(Doctor[] doctors){
        System.out.println("Doctors are in hospital: " + new Hospital().getNumOfDoctorInHospital());
        System.out.println("Patients are in hospital: " + new Hospital().getNumOfPatientsInHospital());
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
            System.out.println(new Hospital().getNumOfDoctorPatients(doctor));
            for (Patient patient: doctor.getPatients()) {
                System.out.println(patient.toString());
            }
        }
    }

    @Override
    public void testRemovePatient(Doctor doctor){
       Patient patient = new Patient(); patient.setName("John");
       new Registry().removeOfDoctorPacients(patient, doctor);
        System.out.println(new Hospital().getNumOfDoctorPatients(doctor));
    }



}
