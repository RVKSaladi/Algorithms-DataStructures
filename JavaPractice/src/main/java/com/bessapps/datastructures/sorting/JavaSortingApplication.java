package com.bessapps.datastructures.sorting;

import java.util.Collection;
import java.util.Collections;

class MySort {
    private int[] theArray;
    private int arraySize; // default

    public MySort() {
        arraySize = 10;
        theArray = new int[arraySize];
    }

    public MySort(int size) {
        arraySize = size;
        theArray = new int[arraySize];
    }

    public int getArraySize() {
        return arraySize;
    }

    public void generateRandomArray(){
        for(int i = 0; i < arraySize; i++){
            theArray[i] = (int)(Math.random()*100)+10;
        }
    }

    public void printHorzArray(int i, int j){
        for(int n = 0; n < arraySize*2; n++) System.out.print("----");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.printf("| %3d  ",n);
        }
        System.out.println("|");
        for(int n = 0; n < arraySize*2; n++)System.out.print("----");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.printf("| %3d  ",theArray[n]);
            //System.out.print("| " + theArray[n] + " ");
        }
        System.out.println("|");
        for(int n = 0; n < arraySize*2; n++)System.out.print("----");
        System.out.println();
        // END OF FIRST PART

        // ADDED FOR BUBBLE SORT
        if(j != -1) {
            // ADD THE +2 TO FIX SPACING
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
            System.out.print(j);
        }
        // THEN ADD THIS CODE
        if(i != -1){
            // ADD THE -1 TO FIX SPACING
            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
    }

    // Linear search
    // Time complexity O(nlogn)
    // Space Complexity O(n)
    public void linearSearch(int val) {
        int pos = 0;
        for(int i = 0; i < arraySize; i++) {
            if(theArray[i] == val ) {
                pos = i;
                break;
            }
            //printHorzArray(i,-1);
        }
        if(pos > 0) {
            System.out.println("Yes "+val+ " is available in the Array at index " + pos);
        } else {
            System.out.println("No "+val+" is not available in the Array");
        }
    }

    public void swapValues(int index1, int index2) {
        int temp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = temp;
    }

    public void swapValues(int [] tArray, int index1, int index2) {
        int temp = tArray[index1];
        tArray[index1] = tArray[index2];
        tArray[index2] = temp;
    }

    public void bubbleSort() {
        //System.out.println("--------------------------Bubble Sort-------------------------------------");
        int count = 0;
        for(int  i = arraySize-1; i > 1; i--) {
            for(int j = 0; j < i; j++) {
                if(theArray[j] > theArray[j+1]) {
                    swapValues(j, j+1);
                    //printHorzArray(i, j);
                    count++;
                }
            }
        }
        //System.out.println("--------------------------Bubble Sort-------------------------------------");
        System.out.println("Number of iterations to complete Bubble sort: of array size " +  arraySize + " is " + count);
    }

    public void binarySearch(int value) {
        int low = 0;
        int high = theArray.length-1;
        int mid = 0;
        int iterationCount = 0;
        while(low < high) {
            System.out.println(" Iteration count: " + iterationCount++);
            mid = (low + high)/2;
            if(theArray[mid] == value) {
                System.out.println("From BinarySearch Function: The Value: " + value + " found at " + mid);
                return;
            } else if(theArray[mid] < value) {
                low = mid+1;
            } else  {
                high = mid-1;
            }
        }
        System.out.println("From BinarySearch Function: The Value: " + value + ", couldn't be found");
    }

    public void selectionSort() {

        for(int i = 0; i < arraySize; i++) {
            int minimum = i;
            for(int j = i; j < arraySize; j++) {
                if(theArray[j] < theArray[minimum]) {
                    minimum = j;
                }
            }
            swapValues(i, minimum);
            printHorzArray(i, -1);
        }
    }

    public void insertionSort() {
        for(int i = 1; i < arraySize; i++) {
            int temp = theArray[i];
            int j = i;
            while(j > 0 && theArray[j-1] > temp) {
                theArray[j] = theArray[j - 1];
                j--;
            }
            theArray[j] = temp;
        }
        printHorzArray(-1, -1);
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while( i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while(i < left.length) result[k++] = left[i++];
        while(j < right.length) result[k++] = right[j++];

        return result;

    }

    // Merge Sort
    public int[] mergeSortHelper(int[] array) {
        if(array.length <= 1) return array;
        int midPoint = array.length/2;
        int [] leftArray = new int[midPoint];
        int [] rightArray = new int[array.length - midPoint];

        System.arraycopy(array, 0, leftArray, 0, leftArray.length);
        System.arraycopy(array, midPoint, rightArray, 0, rightArray.length);

        leftArray = mergeSortHelper(leftArray);
        rightArray = mergeSortHelper(rightArray);
        int [] result = merge(leftArray, rightArray);
        return result;
    }

    public void mergeSort() {
        theArray = mergeSortHelper(theArray);
        printHorzArray(-1, -1);
    }

    public void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void quickSort() {
        quickSort(theArray, 0, arraySize-1);
        printHorzArray(-1, -1);
    }

    public void quickSort(int [] myArray, int start, int end) {
        if(start >= end) return;

        // I choose a point where I want to compare, for best time complexity I choose in the middle of the Array
        int pivot = myArray[(start+end)/2];

        // I need an index point where I will be partitioning the original Array
        int index = partitionArray(myArray, start, end, pivot);
        quickSort(myArray, start, index-1);
        quickSort(myArray, index, end);
    }

    public int partitionArray(int[] tArray, int start, int end, int pivot) {
        while(start <= end) {
            while(tArray[start] < pivot) start++;
            while(tArray[end] > pivot) end--;

            if(start <= end) {
                swapValues(tArray, start++, end--);
            }
        }
        return start;
    }
}

public class JavaSortingApplication {
    public static void main(String args[]) {
        MySort newArray = new MySort();
        newArray.generateRandomArray();
        newArray.printHorzArray(-1,-1);

        //newArray.linearSearch(55);
        //newArray.bubbleSort();
        //newArray.selectionSort();
        //newArray.printHorzArray(-1,-1);
        //newArray.binarySearch(55);
        //newArray.insertionSort();
        //newArray.mergeSort();
        newArray.quickSort();

    }
}
