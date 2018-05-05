package com.company;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

abstract class Spiewak extends Thread implements Comparable<Spiewak> {
    private String name;
    static final AtomicLong NEXT_ID = new AtomicLong(1);
    final long id = NEXT_ID.getAndIncrement();

    public long getId() {
        return id;
    }

//    public String getName() {
//        return name;
//    }

    public Spiewak(String name) {
        this.setName(name);
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return getName()+ ": " + spiewaj();
    }

    public static Spiewak najglosniej(Spiewak[] spiewaks) {
        Spiewak loudest = null;
        int noise = -1;
        for (Spiewak spiewak : spiewaks) {
            int loud = spiewak.loud();
            if (loud > noise) {
                noise = loud;
                loudest = spiewak;
            }
        }
        return loudest;
    }

    public int loud() {
        return  (int) this.spiewaj().chars().distinct().count();
    }

//    @Override
//    public int compareTo(Spiewak o) {
//       return Integer.compare(this.loud(), o.loud());
//    }


    @Override
    public int compareTo(Spiewak o) {
        return Comparator.comparing(Spiewak::loud).reversed()
                .thenComparing(Spiewak::getName)
                .thenComparing(Spiewak::getId)
                .compare(this, o);
    }
}
