package com.company;

public class TempMain {
    public static void main(String[] args) {
        String string1 = "Ipsum lorem";
        String reversedString = "";
        for (int i = 1; i <= string1.length(); i++) {
            reversedString = reversedString + string1.charAt(string1.length()-i);
        }
        System.out.println(reversedString);
    }
}
