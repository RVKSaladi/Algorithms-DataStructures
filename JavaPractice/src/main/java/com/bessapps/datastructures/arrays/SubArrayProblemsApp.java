package com.bessapps.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayClass {
    int[] array;
    public ArrayClass(int[] a) {
        array = a;
    }

    public int[] getArray() {
        return array;
    }

    public void printArray() {
        for(int a:  array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}

public class SubArrayProblemsApp {
    public static void main(String[] args) {
        int[] arr = {42, 63, 2, 40, -3, 58, 23, 560, 23, 80, 9};
        ArrayClass arrayClass = new ArrayClass(arr);
        //arrayClass.printArray();

        int x = 58;
        int sum = 0;
        while(x > 0) {
            sum += x%10;
            x = x/10;
        }
        System.out.println(sum);
    }
}
