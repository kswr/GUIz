package com.company;

public class Muzyk {
    private String imie;
    private String instrument;
    private double czas;
    private double stawka;

    public Muzyk(String imie, String instrument, double czas, double stawka) {
        this.imie = imie;
        this.instrument = instrument;
        this.czas = czas;
        this.stawka = stawka;
    }

    public Muzyk(){
        this("Unknown", "Unknown", -1, -1);
    }

    public String imie() {
        return imie;
    }

    public String instrument() {
        return instrument;
    }

    public double czas() {
        return czas;
    }

    public double stawka() {
        return stawka;
    }

    public static Muzyk maxHonorarium(Muzyk[] muzycy) {
        Muzyk tempMuzyk = new Muzyk();
        double maxHon = 0.0d;
        for (int i = 1; i < muzycy.length; i++) {
           if (muzycy[i].stawka() > maxHon) {
               maxHon = muzycy[i].stawka();
               tempMuzyk = muzycy[i];
           }
        }
        return tempMuzyk;
    }

    @Override
    public String toString() {
        return this.imie + ", czas = " + this.czas + " godz., stawka = " + this.stawka;
    }
}
