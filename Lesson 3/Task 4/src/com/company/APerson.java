package com.company;

abstract class APerson {
    private String name;

    public APerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
