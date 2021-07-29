package com.bessapps.datastructures.strings;

import jdk.swing.interop.SwingInterOpUtils;

public class SubStringProblemOne {

    public static boolean checkIfMatches(String orig, String pattern) {
        //Extract data from the pattern
        StringBuilder sb1 = new StringBuilder();

        String[] tempArray = pattern.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        System.out.println("Total size of the orig string: " + orig.length());

        int temp = 0;
        for(String s: tempArray) {
            if(!s.matches("[/0-9]")) {
                int pos = orig.indexOf(s, temp);
                if(pos == -1 || (temp != pos)) return false;
                System.out.println(s + " : "+" pos = " + pos + " temp: " + temp);
                temp += s.length();
            } else {
                temp += Integer.parseInt(s);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String original = "PraiseTheLordJesusforeverandever";
        String pattern = "6The4Jesus3ever3ever";

        boolean status = checkIfMatches(original, pattern);
        System.out.println(status);
    }
}
