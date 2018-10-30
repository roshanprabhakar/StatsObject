package com.roshanp.compsci;

public class Entry {
    private char entry;
    private int frequency;

    public Entry(char entry, int frequency) {
        this.entry = entry;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getIdentity() {
        return this.entry;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setIdentity(char entry) {
        this.entry = entry;
    }

    public void addFrequency(int frequency) {
        this.frequency += frequency;
    }

    public String getPrintStatement() {
        String output = "";
        output += this.entry;
        output += "=";
        output += this.frequency;
        return output;
    }
}
