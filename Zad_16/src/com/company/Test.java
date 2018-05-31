package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("dupa");
        strings.add("ipsum1");
        ListIterator stringsIterator = strings.listIterator();
        while (stringsIterator.hasNext()) {
            System.out.println(stringsIterator.next());
        }
    }
}
