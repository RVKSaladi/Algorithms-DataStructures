package com.bessapps.datastructures.sorting;

import java.util.Arrays;

class SortClass {
    int iterCount = 0;

    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void bubbleSortBrute(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]) swap(arr, i, j);
                count++;
            }
        }
        System.out.println("Total number of Iterations: " + count + " for " + arr.length + " elements..");
    }

    public void bubbleSort(int[] arr) {
        int count = 0;
        boolean swapStatus = false;
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                //System.out.print(arr[j] + " -- " + arr[j+1]);
                if(arr[j] > arr[j+1]) {
                    swapStatus = true;
                    swap(arr, j, j+1);
                }
                //System.out.println( " ** " + arr[j] + " -- " + arr[j+1]);
                count++;
            }
            if(swapStatus == false) break;
        }
        System.out.println("Total number of Iterations: " + count + " for " + arr.length + " elements..");
    }

    public void selectionSort(int[] arr) {

    }

    public void mergeSort(int[] arr) {

    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        for(int j = low; j <= high-1; j++) {
            if(arr[j] < pivot) {
                swap(arr, low++, j);
            }
            iterCount++;
        }
        swap(arr, low, high);
        return (low);
    }

    public void quickSort(int[] arr, int low, int high) {
        int index = partition(arr, low, high);
        if(low < index-1) quickSort(arr, low, index-1);
        if(index < high) quickSort(arr, index, high);
    }

    public void inserstionSort(int[] arr) {

    }

    public void printArray(int[] ary) {

        for(int x: ary) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    public int getIterCount() {
        return iterCount;
    }

}

public class SortingApplicaiton2 {
    public static void main(String args[]) {
        SortClass sort = new SortClass();

        /*
        int[] array = { 434, 53, 20, -23, 589, 3, 6, 69, 28, 1, 45, 2999};
        sort.printArray(array);
        sort.bubbleSortBrute(array);
        sort.printArray(array);
        */

        /*
        // re initializing
        int[] array1 = { 434, 53, 20, -23, 589, 3, 6, 69, 28, 1, 45, 2999};
        sort.printArray(array1);
        sort.bubbleSort(array1);
        sort.printArray(array1);
        */

        int[] array2 = { -2344, 53, 20, 4234, -23, 589, 3, 6, 69, -200, 28, 1, 45 };
        sort.printArray(array2);
        sort.quickSort(array2, 0, array2.length-1);
        System.out.println("Number of Iterations: " + sort.getIterCount() + " for elements "+ array2.length);
        sort.printArray(array2);

    }
}
