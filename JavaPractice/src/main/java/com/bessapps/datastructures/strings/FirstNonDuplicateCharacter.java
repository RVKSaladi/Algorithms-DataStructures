package com.bessapps.datastructures.strings;

import java.util.*;

public class FirstNonDuplicateCharacter {
    public static void main(String [] args) {
        String s = "aaabaaaccadddfaa";
        char c = firstIndexOfChar(s);
        System.out.println("First Unique Char: " + c);
        c = lastIndexOfChar(s);
        System.out.println("Last Uniqueue Char: " + c);

        c = getFirstCharUsingMap(s);
        System.out.println("First Unique Char(using Map): " + c);

        System.out.println("-----------------------------------------");
        String str = "ravisaladi";
        int x = getLengthOfMaxSubStringNonRepeating(str);
        System.out.println("Length of max sub string: " + x);
        x = getSubLenNonRepeating(str);
        System.out.println("Length of max sub string: " + x);
        System.out.println("-----------------------------------------");


    }

    public static int getSubLenNonRepeating(String s) {
        int max = 0;
        int[] array = new int[26];
        Arrays.fill(array, 0);

        for(int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            array[temp] += 1;
        }
        return max;
    }

    public static char firstIndexOfChar(String s) {

        for(int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '_';
    }

    public static char lastIndexOfChar(String s) {
        char lastOccurrance = '_';
        for(int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                lastOccurrance =  s.charAt(i);
            }
        }
        return lastOccurrance;
    }

    //This doesn't work as we anticipated
    public static char getFirstCharUsingSet(String s) {
        Set<Character> charSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(!charSet.add(s.charAt(i))) {
                charSet.remove(s.charAt(i));
            }
        }
        System.out.println(charSet);
        return '_';
    }

    public static char getFirstCharUsingMap(String s) {
        Map<Character, Boolean> myMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(myMap.containsKey(s.charAt(i))) {
                myMap.put(s.charAt(i), false);
            } else {
                myMap.put(s.charAt(i), true);
            }
        }

        Iterator iter = myMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry myEntry = (Map.Entry)iter.next();
            if((boolean)myEntry.getValue()) {
                return (char)myEntry.getKey();
            }
        }

        return '-';

    }

    public static char lastFirstCharUsingMap(String s) {
        Map<Character, Boolean> myMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(myMap.containsKey(s.charAt(i))) {
                myMap.put(s.charAt(i), false);
            } else {
                myMap.put(s.charAt(i), true);
            }
        }

        Iterator iter = myMap.entrySet().iterator();
        char c = 0;
        while(iter.hasNext()) {
            Map.Entry myEntry = (Map.Entry)iter.next();
            if((boolean)myEntry.getValue()) {
                return (char)myEntry.getKey();
            }
        }

        return '-';

    }

    public static int getLengthOfMaxSubStringNonRepeating(String s) {
        int index1 = 0;
        int index2 = 0;
        int max = 0;

        HashSet<Character> hash_set = new HashSet<>();

        while(index1 < s.length()) {
            if(!hash_set.contains(s.charAt(index1))) {
                hash_set.add(s.charAt(index1));
                index1++;
                max = Math.max(max, hash_set.size());
            } else {
                hash_set.remove(s.charAt(index2));
                index2++;
            }
        }
        return max;
    }
}
