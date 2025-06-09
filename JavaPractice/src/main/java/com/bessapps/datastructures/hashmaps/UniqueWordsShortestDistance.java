package com.bessapps.datastructures.hashmaps;

import java.util.*;

public class UniqueWordsShortestDistance {

    public static void main(String args[]) {
        List<String> wordList = Arrays.asList("dog", "cat", "bird", "cat", "dog", "elephant", "dog");
        Map<String, Integer> x = solution(wordList);
        x.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        });

    }

    public static Map<String, Integer> solution(List<String> wordList) {
        // TODO: implement the function here
        System.out.println(wordList.toString());
        HashMap<String, Integer> myMap = new HashMap<>();
        Map<String, Integer> minDistance = new HashMap<>();

        for(int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if(myMap.containsKey(word)) {
                int prevIndex = myMap.get(word);
                int distance = i - prevIndex;
                minDistance.put(word, Math.min(minDistance.getOrDefault(word, Integer.MAX_VALUE), distance));
            }
            myMap.put(word, i);
        }
        return minDistance;
    }
}
