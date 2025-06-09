package com.bessapps.datastructures.arrays;

import java.util.*;

public class LongestSubarrayWithSumK {

    public static int[] longestSubarrayWithSumK(int[] nums, int k) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        int start = -1, end = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: subarray from index 0 to i
            if (sum == k) {
                if (i + 1 > maxLen) {
                    maxLen = i + 1;
                    start = 0;
                    end = i;
                }
            }

            // Case 2: sum - k seen before
            if (sumIndexMap.containsKey(sum - k)) {
                int prevIndex = sumIndexMap.get(sum - k);
                if (i - prevIndex > maxLen) {
                    maxLen = i - prevIndex;
                    start = prevIndex + 1;
                    end = i;
                }
            }

            // Only store the first occurrence of the prefix sum
            if (!sumIndexMap.containsKey(sum)) {
                sumIndexMap.put(sum, i);
            }
        }

        return (start != -1) ? new int[]{start, end} : new int[0];
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;

//        int[] result = longestSubarrayWithSumK(nums, k);
//        if (result.length > 0) {
//            System.out.println("{" + result[0] + ", " + result[1] + "}");
//        } else {
//            System.out.println("No subarray found with sum = " + k);
//        }

        int result2[] = longestSubarrayWithSumK2(nums, k);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] longestSubarrayWithSumK2(int[] nums, int k) {
        int sum = 0;
        int maxVal = 0;
        List<Integer> resultList1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            temp.add(val);
            sum += val;
            if(sum == k) {
                if(maxVal < temp.size()) {
                    resultList1.clear();
                    resultList1.addAll(temp);
                }
                int x = temp.remove(0);
                sum -= x;
            } else if (sum > k) {
                int x = temp.remove(0);
                sum -= x;
                
                if(sum == k) {
                    if(maxVal < temp.size()) {
                        resultList1.clear();
                        resultList1.addAll(temp);
                    }
                }
            }
        }

        int[] result = new int[resultList1.size()];
        int i = 0;
        for(int x: resultList1) {
            result[i++] = x;
        }
        return result;
    }
}
