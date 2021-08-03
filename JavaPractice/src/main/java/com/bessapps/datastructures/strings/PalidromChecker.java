package com.bessapps.datastructures.strings;


public class PalidromChecker {
    public boolean checkIfStringIsPalindrom(String s) {
        int len = s.length();

        int i = 0;
        int j = len-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}


class PalidromCheckerApp {
    public static void main(String args[]) {
        PalidromChecker pC = new PalidromChecker();
        System.out.println(pC.checkIfStringIsPalindrom("Saladi"));
    }
}
