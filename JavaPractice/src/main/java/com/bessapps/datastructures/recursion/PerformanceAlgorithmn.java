package com.bessapps.datastructures.recursion;

public class PerformanceAlgorithmn {

    public static void test() {
        for(int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
                System.out.print("*");
            } catch (Exception e) {

            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        long x = System.currentTimeMillis();
        test();
        long y = System.currentTimeMillis();
        System.out.println("Total time took to complete this process: "
                + (double)(y-x)/(double)1000 + " (seconds)");
    }
}
