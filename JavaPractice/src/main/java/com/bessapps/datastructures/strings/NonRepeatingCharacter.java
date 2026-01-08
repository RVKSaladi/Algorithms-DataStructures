package com.bessapps.datastructures.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    public char firstNonRepeatingCharacter(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        //Map<Character, Integer> freq = new HashMap<>();

        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Priting the map
//        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
//            System.out.println("=======> " + entry.getKey() + " -- " + entry.getValue());
//        }

        for(Map.Entry<Character, Integer> mapEntry: freq.entrySet()) {
            if(mapEntry.getValue() == 1) {
                return mapEntry.getKey();
            }
        }

        return '_';
    }

    public char secondNonRepeatingCharacter(String s) {
        int counter = 0;
        Map<Character, Integer> freq = new LinkedHashMap<>();
        //Map<Character, Integer> freq = new HashMap<>();

        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> mapEntry: freq.entrySet()) {
            if(mapEntry.getValue() == 1) {
                counter++;
                if(counter == 2) return mapEntry.getKey();
            }
        }

        return '_';
    }

    public void allNonRepeatingCharacter(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        //Map<Character, Integer> freq = new HashMap<>();

        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Priting the map
//        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
//            System.out.println("=======> " + entry.getKey() + " -- " + entry.getValue());
//        }


        System.out.println("\nNon repeating characters in order:");
        for(Map.Entry<Character, Integer> mapEntry: freq.entrySet()) {
            if(mapEntry.getValue() == 1) {
                System.out.println("Non repeating Character: " + mapEntry.getKey());
            }
        }
    }

    public void lastNonRepeatingCharacter(String s) {
        Map<Character, Integer> myMap = new LinkedHashMap<>();

        // Increment if value already exists otherwise create entry with value 1
        for(char c: s.toCharArray()) {
            myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }

        myMap.forEach((k,v) -> {
            System.out.println(k + " ==> " + v);
        });
        System.out.println();

        final char[] ch = new char[1];
        myMap.forEach((k, v) -> {
            if(v == 1) {
                ch[0] = k;
            }
        });
        System.out.println(ch[0]);
    }
}

class FNRCApp {
    public static void main(String args[]) {
        NonRepeatingCharacter fnrc = new NonRepeatingCharacter();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the string: ");
//        String str = scanner.nextLine();
        String str = "ravisaladi";
//
//        System.out.println("In this String: " + str);
//
//        char c = fnrc.firstNonRepeatingCharacter(str);
//        System.out.println("First non repeating char: " + c);
//
//        c = fnrc.secondNonRepeatingCharacter(str);
//        System.out.println("Second non repeating char: " + c);
//
//        fnrc.allNonRepeatingCharacter(str);


        fnrc.lastNonRepeatingCharacter(str);
    }
}
