package com.bessapps.datastructures.strings;

import java.util.*;

public class StringAnagrams {
    public boolean checkIfAnagrams_V2(String str1, String str2) {

        Map<Character, Integer> myMap = new LinkedHashMap<>();

        for(char c: str1.toCharArray()) {
            myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }

        return false;
    }

    public static boolean checkIfAnargam_V1(String str1, String str2) {
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();
        System.out.println(str1);
        System.out.println(str2);

        if(str1.length() != str2.length()) return false;

        int[] counts = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i) - 'a']++; // Increment for first string
            counts[str2.charAt(i) - 'a']--; // Decrement for second string
        }
        for(int c: counts) {
            System.out.print(c + ", " );
        }
        System.out.println();


        // If all counts are zero, they are anagrams
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagramPatterns(String s, String pattern) {
        List<Integer> result = new ArrayList<>();
        s = s.replace(" ", "").toLowerCase();
        pattern = pattern.replace(" ", "").toLowerCase();
        if(s.length() < 1 || pattern.length() < 1 || s.length() < pattern.length()) return result;

        int[] sCount = new int[26];
        int[] tCount = new int[26];

        // Checking the first window
        for(int i = 0; i < pattern.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[pattern.charAt(i) - 'a']++;
        }
        // If the pattern mattecher add the index
        if(Arrays.equals(sCount, tCount)) result.add(0);

        for(int i = pattern.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pattern.length()) - 'a']--;

            if(Arrays.equals(sCount, tCount)) result.add(i - pattern.length() + 1);
        }

        return result;
    }



    public static void main(String[] args) {
        // Strings shouldn't be with any special characters
//        String s1 = "A gentleman";
//        String s2 = "Elegant man";
//
//        if (checkIfAnargam_V1(s1, s2)) {
//            System.out.println(s1 + " and " + s2 + " are anagrams.");
//        } else {
//            System.out.println("They are not anagrams.");
//        }

        String text = "ravisaladilas";
        String pattern = "sal";
        System.out.println("Anagram start indices: " + findAnagramPatterns(text, pattern));
        // Output: [0, 6]
    }
}
