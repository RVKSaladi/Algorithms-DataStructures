package com.bessapps.datastructures.arrays;
import java.util.*;

class Subarray {
    int left;
    int right;
    public Subarray(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        int[] arr = new int[] {left, right};
        return Arrays.toString(arr);
    }
}

public class AverageAboveSum {

    public static void main(String args[]) {
        /*
        int[] A = {3, 4, 2};
        Subarray[] a = aboveAverageSubarrays(A);
        for(Subarray k: a) {
            a.toString();
        }
        */

        int[] B = {-100,-98,-1,2,3,4};
        int x = maximumProduct(B);
        System.out.println(x);
    }

    public static int maximumProduct(int[] nums) {
        if (nums.length < 3) return 0;
        PriorityQueue<Integer> myQueue = new PriorityQueue<>(Collections.reverseOrder());

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    myQueue.offer(nums[i]*nums[j]*nums[k]);
                }
            }

        }

        System.out.println(myQueue);
        int max = 0;
        while(myQueue.size() != 0) {
            max = Math.max(myQueue.poll(), max);
        }

        return max;
    }
}

