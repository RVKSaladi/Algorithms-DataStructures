package com.bessapps.datastructures.hashmaps;

import java.util.*;

public class CharCountFindBestChar {

//    public static void main(String args[]) {
//        String s = "apple ape peal leap";
//        Map.Entry<Character, Integer> x = solution(s);
//    }

    public static Map.Entry<Character, Integer> solution(String s) {
        // TODO: implement

        HashMap<String, HashMap<Character, Integer>> letterMap = new HashMap<>();
        String[] strArray = s.split(" ");
        for(String x: strArray) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for(int i = 0; i < x.length(); i++) {
                tempMap.put(x.charAt(i),
                        tempMap.getOrDefault(x.charAt(i), 0) + 1);
            }
            letterMap.put(x, tempMap);
        }



        System.out.println(letterMap.toString());


        return Map.entry('\0', 0);
    }

    public static Map.Entry<Character, Integer> findMaxBreakingChar(String s) {

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(s.trim().split("\\s+")));

        // Map to track which words each character appears in
        Map<Character, Set<String>> charToWords = new HashMap<>();

        for (String word : uniqueWords) {
            System.out.println(word);
            Set<Character> seen = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (seen.add(c)) {
                    charToWords.computeIfAbsent(c, k -> new HashSet<>()).add(word);
                }
            }
        }
        System.out.println(charToWords.toString());

        // To preserve the first occurring character
        Set<Character> seenOrder = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') seenOrder.add(c);
        }
        System.out.println(seenOrder.toString());

        Character resultChar = null;
        int maxBroken = 0;

        for (char c : seenOrder) {
            Set<String> brokenWords = charToWords.getOrDefault(c, Collections.emptySet());
            if (brokenWords.size() > maxBroken) {
                resultChar = c;
                maxBroken = brokenWords.size();
            }
        }

        return new AbstractMap.SimpleEntry<>(resultChar, maxBroken);
    }

    // Test
    public static void main(String[] args) {
        //System.out.println(findMaxBreakingChar("Hello, world!")); // Output: l=2
        System.out.println(findMaxBreakingChar("Life is like a box of chocolates")); // Output depends on frequency
        //System.out.println(findMaxBreakingChar("1... 2... 3... Go!")); // e.g., '.'=3
    }
}
