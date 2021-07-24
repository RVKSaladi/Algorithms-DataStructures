package com.bessapps.datastructures.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RAToFindSumInArray {

    public static int findIfArrayHasSums(int[] array, int index) {
        if(index == 0) {
            return array[index];
        }
        else {
            if(findIfArrayHasSums(array, index) == findIfArrayHasSums(array,index-1) + findIfArrayHasSums(array, index-2)) {
                System.out.println("Found: " + array[index] + " is the sum of previous");
                return index;
            }
        }
        return 0;
    }

    public static void bruteForceToFindSum(int[] array) {
        if(array.length < 3) return;
        int numberOfOccurances = 0;
        int numberOfIterations = 0;

        int size = array.length;
        for(int i = 2; i < size; i++) {
            for(int j = 0; j < i; j++) {
                for(int k = j+1; k < i; k++) {
                    numberOfIterations++;
                    if(array[i] == array[j]+array[k]) {
                        numberOfOccurances++;
                        System.out.println("Found Sum: " + array[i] + " = " + array[j] + " + " + array[k]);
                    }
                }
            }
        }
        System.out.println("Number of Sums found: "  + numberOfOccurances + " with " + numberOfIterations);
    }

    public static void main(String args[]) {
        int[] array = {4, 2, 3, 6, 5, 9, 13, 18};

        //int x = findIfArrayHasSums(array, array.length-2);
        //System.out.println(x);
        //bruteForceToFindSum(array);

        /*
        for(int x: array) System.out.print(x + " ");
        System.out.println();

        for(int i = 0; i < array.length; i++) {
            int a = find_SumPair(array, array.length, i);
            if(a > 0) {
                System.out.print(a + " ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println();
        */
        /*
        boolean status = check(array, array.length-1);
        System.out.println(status);
        */

        int[] arr = {4, 2, 3, 4, 19, 50, 27, 77};
        boolean status = solution1(arr, 2, 1, 0);
        System.out.println("solution1: " + status);

        boolean a = checkSumUsingHashMap(arr);
        System.out.println(a);

    }

    public static boolean check(int[] array, int index) {
        if(array.length < 2) return false;
        if(array[index] == array[index-1+array[index-2]]) return true;
        return check(array, index-1);
    }

    //Another brute Force
    public static int find_SumPair(int [] array, int size, int sum) {
        for(int i = 0; i < size-1; i++) {
            for(int j = i+1; j< size-1; j++ ) {
                if(array[i] + array[j] == sum) {
                   return sum;
                }
            }
        }
        return 0;
    }

    public static boolean solution1(int[] array, int i, int j, int k) {
        if(array.length < 2) return false;

        if(array[i] == array[j] + array[k]) {
            return true;
        } else {
            if(k+1 < j) {
                return solution1(array, i, j, k+1);
            } else if(j+1 < i) {
                return solution1(array, i, j+1, 0);
            } else if(i+1 < array.length) {
                return solution1(array, i+1, 1, 0);
            } else {
                return false;
            }
        }
    }

    // Find the sum using HashMap
    // Time complexity: O(
    public static boolean checkSumUsingHashMap(int [] array) {
        HashMap<Integer, Integer> hash_map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            hash_map.put(i, array[i]);
        }

        Iterator iter = hash_map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry x = (Map.Entry)iter.next();
            System.out.print("(" + x.getKey() + "-" + x.getValue() + ") ");
        }

        for(int i = 2; i < array.length; i++) {
            if(hash_map.containsKey(array[i]-array[i-1])) {
                
            }
        }

        return true;
    }
}
