package com.bessapps.datastructures.recursion;

import java.util.Random;

public class TwoDimentionalArraySum {

    public static int[][] getArray(int x) {
        int[][] my2DArray = new int[x][x];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                my2DArray[i][j] = rand.nextInt(50);
            }
        }
        return  my2DArray;
    }

    public static void printArray(int[][] array) {
        int rowLen = array.length;
        int colLen = array[0].length;

        System.out.println();
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int getSumOfArray2Dim(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    // Get the sum of the 2 dimentional array recursively
    // Time complexity O(N.M) -  where N is row num, m is col num..
    public static int getSumOfArrayRecursive(int[][] array, int x, int y) {
        if(x == 0 && y == 0) {
            return array[x][y];
        } else {
            if(y-1 >= 0) return array[x][y] + getSumOfArrayRecursive(array, x, y - 1);
            else if(x-1 >= 0) return array[x][y] + getSumOfArrayRecursive(array, x-1, array.length-1);
            else return 0;
        }

    }

    public static int getSumOfArray(int[] array, int index) {
        if(array.length == 0) return 0;
        if(index == 0) return array[index];
        else {
            return array[index] + getSumOfArray(array, index-1);
        }
    }

    public static void main(String args[]) {
        int arraySize = 5;
        int[][] array = getArray(arraySize);
        //printArray(array);
        long startTime = System.currentTimeMillis();
        int x = getSumOfArray2Dim(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time took to complete bruteforce process: "
                + (double)(endTime-startTime)/(double)1000 + " (seconds)");
        System.out.println("Brute Force: " + x);

        startTime = System.currentTimeMillis();
        int y = getSumOfArrayRecursive(array, arraySize-1, arraySize-1);
        endTime = System.currentTimeMillis();
        System.out.println("Total time took to complete recursive process: "
                + (double)(endTime-startTime)/(double)1000 + " (seconds)");
        System.out.println("Recursive: " + y);

        int[] sArray = {1, 2, 1, 3, 1};
        int z = getSumOfArray(sArray, sArray.length-1);
        System.out.println("Sum of Array(Single dim): " + z);
    }
}
