package com.bessapps.datastructures.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatingCharacters {

    public char firstRepeatingCharacter(String s) {
        Map<Character, Integer> myMap = new LinkedHashMap<>();

        for(char c: s.toCharArray()) {
            myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }

//        char[] ch = new char[1];
//        myMap.forEach((k, v) -> {
//            System.out.println(k + " ==> " + v);
//            if(v > 1) {
//                ch[0] = k;
//                break;
//            }
//        });

        myMap.forEach((k, v) -> {
            System.out.println(k + " ==> " + v);
        });

        for(Map.Entry<Character, Integer> entry:  myMap.entrySet()) {
            if(entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return '-';
    }

    public Character firstRepeatingCharacterV2(String s) {
        Map<Character, Integer> myMap = new LinkedHashMap<>();

        for(char c: s.toCharArray()) {
            if(myMap.getOrDefault(c, 0) > 1) {
                return c;
            } else {
                myMap.put(c, myMap.getOrDefault(c, 0) + 1);
            }
        }

        return '-';
    }

    public Character lastRepeatingCharacter(String s) {
        Map<Character, Integer> myMap = new LinkedHashMap<>();
        char retChar = '-';
        for(char c: s.toCharArray()) {
            if(myMap.getOrDefault(c, 0) > 1) {
                retChar = c;
            }
            myMap.put(c, myMap.getOrDefault(c, 0) + 1);
        }

        return retChar;
    }
}

class RepCharApp {
    public static void main(String args[]) {

        String s = "ravisaladisaladi";

        RepeatingCharacters rep = new RepeatingCharacters();
        System.out.println("First repeating character: " + rep.firstRepeatingCharacter(s));
        System.out.println("First repeating character: " + rep.firstRepeatingCharacterV2(s));
        System.out.println("Last repeating character: " + rep.lastRepeatingCharacter(s));



    }
}
