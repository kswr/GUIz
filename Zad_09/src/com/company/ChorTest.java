package com.company;

public class ChorTest {
    public static void main(String[] args) throws InterruptedException{

        Chor chor = new Chor("ABC");
        for (Thread t : chor.getThreads()) System.out.println(t.getName());
        /*<- tu uruchomić
             wszystkie kody w wątkach
         */
        for (Thread t: chor.getThreads()){
            t.start();
        }

        Thread.sleep(10000);

        /*<- tu trzeba zapisać
           fragment, który kończy działanie kodów, wypisujących znaki
        */
        for (Thread t: chor.getThreads()) {
            t.interrupt();
        }

        System.out.println("\nProgram skończył działanie");
    }
}
