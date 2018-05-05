package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Chor extends Thread{
    private ArrayList<Spiewak> chor = new ArrayList<>();
    private String repertuar;

    public ArrayList<Thread> getThreads(){
        ArrayList<Thread> threads = new ArrayList<>();
        threads.addAll(chor);
        return threads;
    }

    public Chor(String repertuar) {
        Random random = new Random();
        this.repertuar = repertuar;
        for (int i = 0; i < repertuar.length(); i++) {
            char c = repertuar.charAt(i);
            chor.add(new Spiewak("Spiewak " + c) {
                @Override
                String spiewaj() {
                    if (random.nextFloat() < 0.5) {
                        System.out.print(String.valueOf(c).toLowerCase());
                    } else {
                        System.out.print(String.valueOf(c).toUpperCase());
                    }
                    return String.valueOf(c);
                }


                @Override
                public void run() {
                    Random random = new Random();
                    while (true) {
                        spiewaj();
                        try {
                            Thread.sleep(random.nextInt(2000));
                        } catch (InterruptedException e){
                            return;
                        }
                    }
                }
            });
        }
    }
}
