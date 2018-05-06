package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public class Informatyk implements Comparable<Informatyk>{
    private String nazwisko;
    private double pensja;
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final int numer = (int) NEXT_ID.getAndIncrement();

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public int getNumer() {
        return numer;
    }

    public Informatyk(String nazwisko, double pensja) {
        this.nazwisko = nazwisko;
        this.pensja = pensja;
    }

    @Override
    public int compareTo(Informatyk o) {
        return Comparator.comparing(Informatyk::getPensja)
                .thenComparing(Informatyk::getNazwisko)
                .thenComparing(Informatyk::getNumer).reversed()
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "Informatyk: " + getNazwisko() + " Id: " + getNumer() + " Pensja: " + getPensja();
    }
}
