package com.example.nurse;

public class Patient {
    @Inject
    private Glucose glucose;

    public Glucose getGlucose() {return glucose;}
    public void setGlucose(Glucose glucose) {this.glucose = glucose;}
}
