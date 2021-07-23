package com.bessapps.datastructures.recursion;

public class Fibonacci {

    public static int createFibonacci(int x) {
        if(x <= 1) {
            return 1;
        } else {
            int res = createFibonacci(x-1) + createFibonacci(x-2);
            System.out.print(res + ",");
            return res;
        }
    }

    public static void main(String args[]) {
        int x = createFibonacci(2);
        System.out.println(" And Sum = " + x);
    }
}
