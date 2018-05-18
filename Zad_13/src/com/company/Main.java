package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data/data.txt");
        Scanner scanner = new Scanner(file);

        System.out.println(scanner.nextLine());
    }
}
