package com.bessapps.datastructures.hashset;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindDuplicatesUsingHashSet {
    public char[] solution(String s, char[] letters) {

        System.out.println(s);
        System.out.println(Arrays.toString(letters));
        ArrayList<Character> myList = new ArrayList<>();
        // TODO: implement
        HashSet<Character> mySet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            mySet.add(s.charAt(i));
        }

        int index = 0;
        for(int i = 0; i < letters.length; i++) {
            if(mySet.contains(letters[i])) {
                myList.add(letters[i]);
            }
        }

        Collections.sort(myList);
        char[] arr = new char[myList.size()];
        for(int i = 0; i < myList.size(); i++) {
            arr[i] = myList.get(i);
        }

        return arr;
    }
}