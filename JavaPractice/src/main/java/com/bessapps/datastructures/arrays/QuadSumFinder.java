package com.bessapps.datastructures.arrays;

import java.util.*;

public class QuadSumFinder {
    public static List<Integer> findQuadSum(int targetSum, List<Integer> numbers) {
        int length = numbers.size();
        Map<Integer, List<int[]>> sumMap = new HashMap<>();

        // Step 2: Populate the HashMap with the sums of all pairs
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int pairwiseSum = numbers.get(i) + numbers.get(j);
                sumMap.computeIfAbsent(pairwiseSum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

//        sumMap.forEach((k, v) -> {
//            System.out.print(k + " ---> ");
//            v.forEach((x) -> System.out.println(Arrays.toString(x)));
//        });

        // Step 3: Iterate over the sums
        for (int sum : sumMap.keySet()) {
            int complement = targetSum - sum;
            if (sumMap.containsKey(complement)) {
                System.out.println("xxxxxx: " + complement + " " + targetSum + " " + sum + " " + Arrays.toString(sumMap.get(complement).get(0)));
                List<int[]> pairs1 = sumMap.get(sum);
                List<int[]> pairs2 = sumMap.get(complement);

                for (int[] pair1 : pairs1) {
                    for (int[] pair2 : pairs2) {
                        int a = pair1[0], b = pair1[1];
                        int c = pair2[0], d = pair2[1];
                        //System.out.println("===>: " + a + " " + b + " " + c + " " + d);

                        // Ensure all indices are distinct
                        //if (a != c && a != d && b != c && b != d) {
                            return Arrays.asList(numbers.get(a), numbers.get(b), numbers.get(c), numbers.get(d));
                        //}
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        //List<Integer> numbers = Arrays.asList(5, 15, 2, 7, 8, 4);
        //int target = 24;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 9, 10);
        int target = 6;
        System.out.println(findQuadSum(target, numbers));
    }
}