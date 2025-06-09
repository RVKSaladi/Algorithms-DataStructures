package com.bessapps.datastructures.hashmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class SplitStringInToLargestPossibleParts {

    public static void main(String args[]) {
        List<Integer> x = solution("abacddc");
    }
    public static List<Integer> solution(String s) {
        // TODO: implement the function

        Map<Character, Integer> lastIndex = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Step 1: Record the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        System.out.println(lastIndex.toString());
        int start = 0, end = 0;

        // Step 2: Scan and find partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if (i == end) {
                System.out.println(end + " ---> " +  i);
                // Make a cut
                result.add(s.substring(start, end + 1));
                start = i + 1;
            }
        }

        System.out.println(result.toString());
        List<Integer> sizeList = new ArrayList<>();
        result.forEach((x) -> sizeList.add(x.length()));
        return sizeList;
    }
}
