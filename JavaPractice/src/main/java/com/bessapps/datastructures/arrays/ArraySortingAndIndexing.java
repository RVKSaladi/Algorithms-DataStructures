package com.bessapps.datastructures.arrays;

import java.util.Arrays;

public class ArraySortingAndIndexing {
    public static void main(String args[]) {

        long[] A = new long[] {10, 20, 30, 40, 50};
        long[] B = new long[] {7, 5, 1, 2, 4};

        long[] x = optimizedReplace(A, B);
        System.out.println(Arrays.toString(x));

    }
    public static long[] optimizedReplace(long[] A, long[] B) {
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));

        // Step 1: Pair B[i] with its original index
        long[][] pairedArray = new long[B.length][2];
        for (int i = 0; i < B.length; i++) {
            pairedArray[i][0] = B[i]; // value
            pairedArray[i][1] = i;    // original index
        }

        // Step 2: Sort the pairs by value
        Arrays.sort(pairedArray, (a, b) -> Long.compare(a[0], b[0]));

        // Step 3: For each value in sorted B, find closest neighbor in B
        long[] result = new long[B.length];
        for (int i = 0; i < pairedArray.length; i++) {
            long currVal = pairedArray[i][0];
            int currIdx = (int)pairedArray[i][1];

            long minDiff = Long.MAX_VALUE;
            int closestOrigIdx = -1;

            // Only need to compare with neighbors in sorted array
            if (i > 0) {
                long leftDiff = Math.abs(currVal - pairedArray[i - 1][0]);
                if (leftDiff < minDiff) {
                    minDiff = leftDiff;
                    closestOrigIdx = (int) pairedArray[i - 1][1]; // original index
                }
            }

            if (i < pairedArray.length - 1) {
                long rightDiff = Math.abs(currVal - pairedArray[i + 1][0]);
                if (rightDiff < minDiff) {
                    minDiff = rightDiff;
                    closestOrigIdx = (int) pairedArray[i + 1][1]; // original index
                }
            }

            // Step 4: Use the closest index to get value from A
            result[currIdx] = A[closestOrigIdx];
        }

        System.out.println("Result: " + Arrays.toString(result));
        return result;
    }


}