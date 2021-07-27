package com.bessapps.datastructures.arrays;

public class ArrayCombinations {
    public static void main(String[] args) {
        /*
        char[] cArray = {'A', 'B', 'C', 'D', 'E', 'F'};

        int count = 0;
        for(int i = 0; i < cArray.length; i++) {
            for(int j = i+1; j < cArray.length; j++) {
                for(int k = j+1; k < cArray.length; k++) {
                    count++;
                    System.out.print(" "+cArray[i]+cArray[j]+cArray[k]);
                }
            }
            System.out.println( " -- " + count);
            count = 0;
        }
        */
        int[] B = {-100,-98,-1,2,3,4};
        int count = 0;
        int len = B.length;

        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                for(int k = j+1; k < len; k++) {
                    count++;
                    //System.out.print(" "+cArray[i]+cArray[j]+cArray[k]);
                    System.out.print("[" + i + " " + j + " " + k + "] ");
                }
            }
            System.out.println( " -- " + count);
            count = 0;
        }
    }

}
