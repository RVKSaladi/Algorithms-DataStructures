package com.bessapps.datastructures.arrays;

import java.util.*;


public class FindingElementsForTargetSum {

    public static void main(String args[]) {
        int[] arr = new int[] {1, 2, 3, 4, 9, 10};
        //int[] arr = new int[] {2, 13, 4, 7, 5, 15};
        //int[] arr = new int[] {3, 8, 5, 2};

        int target = 16;
//        int [] x = solution(arr, target);
//        System.out.println(Arrays.toString(x));
        //int[] x = newSolution(arr, target);
        //System.out.println(Arrays.toString(x));
        int[] x1 = anotherSolution(arr, target);
        System.out.println(Arrays.toString(x1));
    }

    public static int[] solution(int[] arr, int target) {
        // TODO: implement a function that finds a pair of numbers whose sum equals the target
        System.out.println(Arrays.toString(arr));
        Map<Integer, List<int[]>> sumMap = new HashMap<>();
        int length = arr.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = i+1; j < length; j++) {
                int pairWiseSum = arr[i] + arr[j];
                sumMap.computeIfAbsent(pairWiseSum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

//        final int[][] result = {new int[1]};
//        sumMap.forEach((k, v) -> {
//            if(k == target) {
//                result[0] = v.get(1);
//            }
//        });

        int[] result = new int[2];
        for(Map.Entry<Integer, List<int[]>> entry:  sumMap.entrySet()) {
            if(entry.getKey() == target) {
                int[] x = entry.getValue().get(1);
                result[0] = arr[x[0]];
                result[1] = arr[x[1]];
            }
        }

        return result;
    }

    public static int[] newSolution(int[] arr, int target) {
        System.out.println(Arrays.toString(arr));
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;
            System.out.println("Complement: " + complement + " num: " + num);
            if (seen.containsKey(complement)) {
                // Found a pair: return the actual numbers
                return new int[]{complement, num};
            }

            // Only add the current number after the check to ensure lowest second index
            seen.putIfAbsent(num, i);

//            seen.forEach((k, v) -> {
//                System.out.println(k + " -- " + v);
//            });

        }

        // No valid pair found
        return new int[0];
    }

    public static int[] anotherSolution(int[] arr, int target) {
        System.out.println(Arrays.toString(arr));
        Set<Integer> complementMap = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;
            //System.out.println("Complement: " + complement + " num: " + num);
            if(complementMap.contains(complement)) {
                return new int[]{complement, num};
            }
            //complementMap.put(complement, complementMap.getOrDefault(complement, i));
            complementMap.add(num);
            //System.out.println(complementMap);
        }

        return new int[]{0};

    }
}
