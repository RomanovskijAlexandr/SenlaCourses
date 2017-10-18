package com.company;

public class Patient extends APerson {
    private String id;

    public Patient(String id) {
        this.id = id;
        System.out.println("create patient");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        boolean truth = false;
        if (this == obj)
            truth = true;
        if (obj == null)
            truth = false;
        if (getClass() != obj.getClass())
            truth = false;
        else {
            if(this.getId() == ((Patient) obj).getId())
                truth = true;
            else
                truth = false;
        }
        return truth;
    }

    @Override
    public String toString() {
        return "Patient id is: " + this.getId();
    }
}
