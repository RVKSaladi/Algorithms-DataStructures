package com.bessapps.datastructures.arrays;

import java.util.*;

public class MaxSumWithKElements {

    public static void main(String args[]) {
        int[] arr = {1, 9, -1, -2, 7, 3, -1, 2, 4, -6};
        int k = 5;
        int[] x = maxSumWithKElements2(arr, k);
        System.out.println(Arrays.toString(x));
    }

    public static int[] maxSumWithKElements(int[] numbers, int k) {
        System.out.println(Arrays.toString(numbers));
        System.out.println(k);
        int[] result = new int[]{0,0};
        int maxSum = 0;

        HashMap<Integer, Integer> maxSumMap = new HashMap<>();
        for(int i = 0; i < k; i++) {
            maxSum += numbers[i];
        }
        maxSumMap.put(0, maxSum);
        int windowSum = maxSum;

        for(int i = 1; i < numbers.length-k; i++) {
            int x = numbers[i-1];
            int y = numbers[i+k-1];
            maxSum = maxSum + y - x;
            maxSum = Math.max(maxSum, windowSum);
            maxSumMap.put(i, maxSum);
        }

        System.out.println(maxSumMap.toString());

        for(int i = 0; i < maxSumMap.size(); i++) {
            if(result[1] < maxSumMap.get(i)) {
                result[1] = maxSumMap.get(i);
                result[0] = i;
            }
        }
        return result; // Placeholder implementation
    }

    public static int[] maxSumWithKElements2(int[] arr, int k) {

        int maxSum = 0;
        int windowSum = 0;
        int maxIndex = 0;

        // Step 1: Compute sum of first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum; // first max
        maxIndex = 0;

        // Step 2: Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];

            if (windowSum > maxSum) {
                maxSum = windowSum;
                maxIndex = i - k + 1;
            }
        }

        return new int[] { maxIndex, maxSum };
    }

}
