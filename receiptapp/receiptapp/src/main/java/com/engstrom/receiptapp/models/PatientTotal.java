package com.engstrom.receiptapp.models;


public class PatientTotal {

    private int total = 0;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PatientTotal(int total) {
        this.total = total;
    }
}
