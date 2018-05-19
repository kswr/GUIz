package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testMain {
    public static void main(String[] args) {
        String test1 = "50 50 50";
        String test2 = "50 50 a";
        String test3 = "a a a";
        String test4 = "50 50";
        String test5 = "50 50 50 ";

        ArrayList<String> testArray = new ArrayList<>();
        testArray.add(test1);
        testArray.add(test2);
        testArray.add(test3);
        testArray.add(test4);
        testArray.add(test5);

        String pattern1 = "^\\S[^\\D](\\s*[\\d]+\\s*){2,3}[^\\D]\\S$";
        String pattern2 = "^\\S[\\d][ ][\\d]\\S$";
        String pattern3 = "^\\S([\\d][ ]){2}[\\d]\\S$";
        String pattern4 = "[\\d]+[ ][\\d]+";
        String pattern5 = "[\\d]+[ ][\\d]+[ ][\\d]+";
        Pattern stringPattern1 = Pattern.compile(pattern4);
        Pattern stringPattern2 = Pattern.compile(pattern5);
        for (String str : testArray) {
            Matcher stringMatcher1 = stringPattern1.matcher(str);
            Matcher stringMatcher2 = stringPattern2.matcher(str);
            System.out.println(stringMatcher1.matches() + "\t" + stringMatcher2.matches());
            stringMatcher1.reset();
            stringMatcher2.reset();
        }
    }
}
