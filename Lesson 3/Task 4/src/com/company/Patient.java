package com.company;

public class Patient extends APerson {
    private String id;

    public Patient(String id, String name) {
        super(name);
        this.id = id;
        System.out.println("create patient");
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient id is: " + this.getId();
    }
}
