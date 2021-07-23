package com.bessapps.datastructures.recursion;

public class CalculatePowerOf {
    public static int count = 0;

    // Time complexity for this is o(n)
    // Space complexity is o(n)
    public static double power(double x, int y) {
        double result  = 0;
        if(y == 0) {
            return 1;
        } else {
            count++;
            result += x * power(x, y-1);
        }
        return result;
    }

    // Time complexity of this method is o(log n)
    // Space complexity of this is o(log n) as well..
    public static double power2(double x, int y) {
        if(y == 0) {
            return 1;
        } else {
            count++;
            double partial = power2(x, y/2);
            double result = partial * partial;

            if(y%2 != 0) {
                result *= x;
            }
            return result;
        }

    }


    public static void main(String args[]) {
        double val1 = 5;
        int val2 = 35;
        double x = power(val1, val2);
        System.out.println(x + "\tFinished in " + count + " iterations..");

        count = 0;
        double y = power2(val1, val2);
        System.out.println(y + "\tFinished in " + count + " iterations..");
    }
}
