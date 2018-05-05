package com.company;

import java.util.concurrent.atomic.AtomicLong;

abstract class Spiewak {
    private String name;
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final long id = NEXT_ID.getAndIncrement();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Spiewak(String name) {
        this.name = name;
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
            int loud = (int) spiewak.spiewaj().toLowerCase().chars().distinct().count();
            if (loud > noise) {
                noise = loud;
                loudest = spiewak;
            }
        }
        return loudest;
    }
}
