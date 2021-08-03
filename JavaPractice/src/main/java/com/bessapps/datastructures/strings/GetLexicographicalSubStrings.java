package com.bessapps.datastructures.strings;

public class GetLexicographicalSubStrings {

    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        if(a.length() < 1 || a.length() > 50 || b.length() < 0 || b.length() > 50) {
            return false;
        }
        char[] aArr = a.toUpperCase().toCharArray();
        char[] bArr = b.toUpperCase().toCharArray();

        /*
        java.util.Arrays.sort(aArr);
        java.util.Arrays.sort(bArr);
        return java.util.Arrays.equals(aArr, bArr);
        */

        // Method 2
        int a1 = 0;
        int a2 = 0;
        for(char c: aArr) {
            a1 += c;
        }
        for(char c: bArr) {
            a2 += c;
        }

        System.out.println(a1 + " -- " + a2);
        if((a1 ^ a2) != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void getMaxString() {

        String s = "welcometojava";
        int range = 3;

        if(!s.matches("^[a-zA-Z]+")) return;
        System.out.println("Original String: " + s);
        String minString = "";
        String maxString = "";
        for(int i = 0; i <= s.length()-range; i++) {
            String temp = s.substring(i, range+i);
            if(maxString == "") {
                maxString = minString = temp;
            }
            if(minString.compareTo(temp) < 0) minString = temp;
            if(maxString.compareTo(temp) > 0) maxString = temp;
        }
        System.out.println("Max String: " + maxString);
        System.out.println("Min String: " + minString);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abd", "acc"));
        testSplit();
    }

    public static void testSplit() {
        String s = "He is a very very good boy, isn't he?";
        String[] temp = s.split("[ !,?._'@]+");
        System.out.println(temp.length);
        for(String t: temp) {
            System.out.println(t);
        }

    }
}
