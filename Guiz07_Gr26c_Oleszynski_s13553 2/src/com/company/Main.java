package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Informatyk> informatycy = new ArrayList<>();
        ArrayList<Programista> programisci = new ArrayList<>();
        ArrayList<Projektant> projektanci = new ArrayList<>();
        ArrayList<Informatyk> rozni = new ArrayList<>();


        informatycy.add(new Informatyk("Parker", 5000.0d));
        informatycy.add(new Informatyk("Besos", 4000.0d));
        informatycy.add(new Informatyk("Dell", 3000.0d));
        informatycy.add(new Informatyk("Gates", 10000.0d));
        informatycy.add(new Informatyk("Jobs", 7000.0d));

        programisci.add(new Programista("Nowak", 5000.0d, "Java"));
        programisci.add(new Programista("Nowacki", 4000.0d, "Python"));
        programisci.add(new Programista("Kowalski", 3000.0d, "JS"));
        programisci.add(new Programista("Adamek", 10000.0d, "Scala"));
        programisci.add(new Programista("Choragiewicz", 7000.0d, "RoR"));

        projektanci.add(new Projektant("Branicki", 5000.0d, 100));
        projektanci.add(new Projektant("Laski", 4000.0d, 10));
        projektanci.add(new Projektant("Kulesza", 3000.0d, 30));
        projektanci.add(new Projektant("Kaczmarski", 10000.0d, 3));
        projektanci.add(new Projektant("Jablonski", 7000.0d, 18));

        rozni.add(new Informatyk("Czarnecki", 5245.2d));
        rozni.add(new Programista("Derda", 1000.0d, "PHP"));
        rozni.add(new Programista("Osuch", 14556.0d, "Groovy"));
        rozni.add(new Programista("Zniszczynski", 20000.0d, "JS"));
        rozni.add(new Projektant("Bukala", 9000.0d, 15));
        rozni.add(new Projektant("Zalewski", 8000.0d, 150));

        informatycy.sort(Informatyk::compareTo);
        programisci.sort(Programista::compareTo);
        projektanci.sort(Projektant::compareTo);
        rozni.sort(Informatyk::compareTo);

        for (Informatyk i: informatycy) {
            System.out.println(i);
        }

        for (Programista i: programisci) {
            System.out.println(i);
        }

        for (Projektant i: projektanci) {
            System.out.println(i);
        }

        for (Informatyk i: rozni) {
            System.out.println(i);
        }
    }
}
