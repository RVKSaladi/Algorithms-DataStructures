package com.bessapps.datastructures.strings;

import java.util.Scanner;

public class StringPatternChecking {

    public static void main(String args[]) {
        /*
        Scanner scan = new Scanner(System.in);
        String origStr = scan.nextLine();
        String pattStr = scan.nextLine();
        */

        String original = "PraiseTheLordJesusforeverandever";
        String pattern = "6The4Jesus3ever3ever";

        boolean status = checkIfPatternMatches(original, pattern);
        System.out.println("The pattern is matching: " + status);
    }

    public static boolean checkIfPatternMatches(String cString, String pString) {
        if(cString.length() <= pString.length()) return false;

        String[] tempArray = pString.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int temp = 0;
        for(String s: tempArray) {
            if(!(s.matches("[/0-9]"))) {
                int pos = cString.indexOf(s, temp);
                if(pos == -1 || pos != temp) return false;
                temp += s.length();
            } else {
                temp += Integer.parseInt(s);
            }
        }

        return true;
    }

}
