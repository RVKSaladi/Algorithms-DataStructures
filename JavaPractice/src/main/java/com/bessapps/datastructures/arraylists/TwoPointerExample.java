package com.bessapps.datastructures.arraylists;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoPointerExample {

    public static void main(String args[]) {
        int[]X = {1, 5, 3, 4, 2};
        int[]Y = {1, 2, 3, 4, 5};
        int[] result = solution1(X, Y);
        System.out.println(Arrays.toString(result));
//        int[] result1 = solution(X, Y);
//        System.out.println("NEW: " + Arrays.toString(result1));
    }

    private static int[] solution1(int[] X, int[] Y) {
        int n = X.length;
        List<SimpleEntry<Integer, Integer>> sortedX = new ArrayList<>();

        // Pair (value, original index) and sort by value
        for (int i = 0; i < n; i++) {
            sortedX.add(new SimpleEntry<>(X[i], i));
        }
        sortedX.sort(Comparator.comparingInt(SimpleEntry::getKey));

        List<Integer> result = new ArrayList<>();

        for (int y : Y) {
            double target = y / 2.0;
            int idx = binarySearchClosest(sortedX, target);
            int originalXIndex = sortedX.get(idx).getValue();
            result.add(Y[originalXIndex]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // Binary search to find index of closest value in sorted list
    private static int binarySearchClosest(List<SimpleEntry<Integer, Integer>> sortedX, double target) {
        int left = 0, right = sortedX.size() - 1;
        int bestIdx = 0;
        double minDiff = Double.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = sortedX.get(mid).getKey();
            double diff = Math.abs(val - target);

            if (diff < minDiff || (diff == minDiff &&
                    sortedX.get(mid).getValue() < sortedX.get(bestIdx).getValue())) {
                minDiff = diff;
                bestIdx = mid;
            }

            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bestIdx;
    }

    public static int[] solution2(int[] X, int[] Y) {
        // TODO: implement

        System.out.println(Arrays.toString(X));
        System.out.println(Arrays.toString(Y));
        List<SimpleEntry<Integer, Integer>> sortedArrayList = new ArrayList<>();
        for(int i = 0; i < X.length; i++) {
            sortedArrayList.add(new SimpleEntry<>(X[i], i));
        }
        sortedArrayList.sort(Comparator.comparingInt(SimpleEntry::getKey));
        Arrays.sort(X);
        List<Integer> resultList= new ArrayList<>();
        for(int i = 0; i < Y.length; i++) {
            int j = 1;
            double target = Y[i]/2.0;
            while(j < X.length-1 && target >= X[j]) {
                j++;
            }
            double t1 = Math.abs(target - X[j-1]);
            double t2 = Math.abs(target - X[j]);
            int index = 0;
            if(t1 < t2) {
                index = j-1;
            } else {
                index = j;
            }
            //System.out.println(sortedArrayList.get(index));
            index = sortedArrayList.get(index).getValue();
            resultList.add(Y[index]);
            //System.out.println(target + ", " + t1 + ", "+t2 + " index: " + index + " value " + Y[index]);
        }
        System.out.println("ResultList: " + resultList.toString());
        int[] result = resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static int[] solution(int[] X, int[] Y) {
        // Step 1: Create a list of (value, original index) pairs
        List<SimpleEntry<Integer, Integer>> sortedList = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            sortedList.add(new SimpleEntry<>(X[i], i));
        }

        // Step 2: Sort list by value
        sortedList.sort(Comparator.comparingInt(SimpleEntry::getKey));
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < Y.length; i++) {
            int target = Y[i] / 2;

            // Binary search to find the closest value to target in X
            int closestIdx = findClosestIndex(sortedList, target);
            int xOriginalIdx = sortedList.get(closestIdx).getValue();

            resultList.add(Y[xOriginalIdx]);
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Helper to find the index in sortedList where value is closest to target
    public static int findClosestIndex(List<SimpleEntry<Integer, Integer>> list, int target) {
        int left = 0, right = list.size() - 1;
        int bestIdx = 0;
        int minDiff = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = list.get(mid).getKey();
            int diff = Math.abs(val - target);

            if (diff < minDiff) {
                minDiff = diff;
                bestIdx = mid;
            } else if (diff == minDiff && val < list.get(bestIdx).getKey()) {
                bestIdx = mid; // break ties by smaller value
            }

            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bestIdx;
    }
}
