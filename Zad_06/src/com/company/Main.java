package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args)
    {

        Spiewak s1 = new Spiewak("Carrey"){
            @Override
            String spiewaj() {
                return "oaoooooooooo";
            }
        };

        Spiewak s2 = new Spiewak("Houston"){
            @Override
            String spiewaj() {
                return "a4iBBiii";
            }
        };

        Spiewak s3 = new Spiewak("Madonna"){
            @Override
            String spiewaj() {
                return "aAa";
            }
        };

        Spiewak s4 = new Spiewak("Darrey"){
            @Override
            String spiewaj() {
                return "eeae";
            }
        };

        Spiewak s5 = new Spiewak("Darrey"){
            @Override
            String spiewaj() {
                return "bebe";
            }
        };

        Spiewak sp[] = {s1, s2, s3, s4, s5};

//        for (Spiewak s : sp)
//            System.out.println(s);
//
//        System.out.println("\n" + Spiewak.najglosniej(sp));

        // Arraylista i sortowanie
        ArrayList<Spiewak> spiewacy = new ArrayList<>();
        Collections.addAll(spiewacy, sp);
        spiewacy.sort(Spiewak::compareTo);
        for (Spiewak s: spiewacy) {
            System.out.println(s);
        }
    }
}
