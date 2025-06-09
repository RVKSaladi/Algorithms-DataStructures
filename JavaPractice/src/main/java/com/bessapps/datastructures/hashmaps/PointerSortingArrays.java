package com.bessapps.datastructures.hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class PointerSortingArrays {

    public List<int[]> findChocPairs(int[] sweetness) {
        // TODO: implement the solution here
        System.out.println(Arrays.toString(sweetness));
        List<int[]> result = new ArrayList<>();
        Arrays.sort(sweetness);
        System.out.println(Arrays.toString(sweetness));
        int left = 0;
        int right = sweetness.length - 1;
        int target = 0;

        while(left < right) {
            int total = sweetness[left] + sweetness[right];
            if( total == target) {
                result.add(new int[]{sweetness[right], sweetness[left]});
                right--;
                left++;
            } else if( total < target) {
                left++;
            } else {
                right--;
            }
        }
        Collections.sort(result, (a,b) -> Integer.compare(a[0], b[0]));
        result.forEach((x) -> System.out.println(Arrays.toString(x)));
        return result;
    }
}
