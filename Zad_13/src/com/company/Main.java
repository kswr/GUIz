package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

//        ArrayList<String> parameters = reader("data.txt");

//        tests for load
//        for (String str : parameters) {
//            System.out.println(str);
//        }

//        ArrayList<int[]> arguments = new ArrayList<>();
//        for (String str : parameters) {
//            arguments.add(intConverter(str));
//        }

//        tests for conversion
//        for (int[] ints : arguments) {
//            for (int i = 0; i < ints.length; i++) {
//                System.out.printf(ints[i] + " ");
//            }
//            System.out.printf("\n");
//        }
        new DrawSwing();


    }

//    public static ArrayList<String> reader(String filename) throws FileNotFoundException {
//        ArrayList<String> tempArray = new ArrayList<>();
//        File file = new File("./data/" + filename);
//        Scanner scanner = new Scanner(file);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            if (validator(line)){
//                tempArray.add(line);
//            }
//        }
//        return tempArray;
//    }
//
//    public static boolean validator(String toValidate) {
//        boolean temp = false;
//        String pattern1 = "[\\d]+[ ][\\d]+[ ][\\d]+";
//        String pattern2 = "[\\d]+[ ][\\d]+[ ][\\d]+[ ][\\d]+";
//        Pattern stringPattern1 = Pattern.compile(pattern1);
//        Pattern stringPattern2 = Pattern.compile(pattern2);
//        Matcher stringMatcher1 = stringPattern1.matcher(toValidate);
//        Matcher stringMatcher2 = stringPattern2.matcher(toValidate);
//        if (stringMatcher1.matches() || stringMatcher2.matches()) {
//            temp = true;
//        }
//        return temp;
//    }
//
//    public static int[] intConverter(String toConversion) {
//        String[] integersString = toConversion.split(" ");
//        int[] integers = new int[integersString.length];
//        for (int i = 0; i < integers.length; i++) {
//            integers[i] = Integer.parseInt(integersString[i]);
//        }
//        return integers;
//    }
}
