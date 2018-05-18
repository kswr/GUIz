package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

    }

    public static ArrayList<String> reader(String filename) throws FileNotFoundException {
        ArrayList<String> tempArray = new ArrayList<>();
        File file = new File("./data/" + filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            tempArray.add(scanner.nextLine());
        }
        return tempArray;
    }

    public static int[] intConverter(String toConversion) {
        String[] integersString = toConversion.split(" ");
        int[] integers = new int[integersString.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integersString[i]);
        }
        return integers;
    }
}
