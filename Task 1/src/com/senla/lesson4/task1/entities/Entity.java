package com.senla.lesson4.task1.entities;

public abstract class Entity {
    private int id;

    public int generateId(int lastId) {
        return lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getStringForPrintInFile();
}
