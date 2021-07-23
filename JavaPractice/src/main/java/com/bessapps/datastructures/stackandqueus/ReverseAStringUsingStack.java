package com.bessapps.datastructures.stackandqueus;

import java.util.Stack;

public class ReverseAStringUsingStack<T> {

    public static int[] reverseAnArray(int[] array) {
        Stack<Integer> myStack = new Stack<>();
        for(int i = 0; i < array.length; i++) {
            myStack.push(array[i]);
        }

        for(int  i = 0; i < array.length; i++) {
            array[i] = myStack.pop();
        }
        return array;
    }

    public static <T> int count(T[] array, T item) {
        int count = 0;

        if (item == null) {
            for (T element : array) {
                if (element == null) count++;
            }
        } else {
            for (T element : array) {
                if (item.equals(element)) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String args[]) {
        int [] x = {3, 5, 45, 2, 5, 340, 5767, 35, 78};
        for(int a: x) {
            System.out.print(a + " ");
        }
        System.out.println();

        x = reverseAnArray(x);
        for(int a: x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
