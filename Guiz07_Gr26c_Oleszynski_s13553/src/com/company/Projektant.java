package com.company;

import java.util.Comparator;

public class Projektant extends Informatyk{
    private int projekty;

    public Projektant(String nazwisko, double pensja, int projekty) {
        super(nazwisko, pensja);
        this.projekty = projekty;
    }

    public int getProjekty() {
        return projekty;
    }

    public void setProjekty(int projekty) {
        this.projekty = projekty;
    }

    public int compareTo(Projektant o) {
        return Comparator.comparing(Projektant::getPensja)
                .thenComparing(Projektant::getNazwisko)
                .thenComparing(Projektant::getNumer)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "Projektant-" + super.toString() + " Projektow: " + getProjekty();
    }
}
