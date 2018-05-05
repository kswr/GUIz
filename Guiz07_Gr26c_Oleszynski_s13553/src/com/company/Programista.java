package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Programista extends Informatyk{
    private String jezyk;

    public Programista(String nazwisko, double pensja, String jezyk) {
        super(nazwisko, pensja);
        this.jezyk = jezyk;
    }

    public String getJezyk() {
        return jezyk;
    }

    public void setJezyk(String jezyk) {
        this.jezyk = jezyk;
    }

    public int compareTo(Programista o) {
        return Comparator.comparing(Programista::getPensja)
                .thenComparing(Programista::getNazwisko)
                .thenComparing(Programista::getJezyk)
                .compare(this, o);

    }

    @Override
    public String toString() {
        return "Programista-" + super.toString() + " Jezyk programowania: " + getJezyk();
    }
}
