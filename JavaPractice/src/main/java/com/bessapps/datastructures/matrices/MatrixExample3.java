package com.bessapps.datastructures.matrices;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MatrixExample3 {

    public static void main(String args[]) {
        MatrixExample3 matrixEx3 = new MatrixExample3();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Map<Integer, Integer> result = matrixEx3.zigzagTraverseAndPrimes(matrix);
        result.forEach((k,v) -> System.out.print("[" + k + ": " + v + "], "));
        System.out.println();
    }

    private static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public Map<Integer, Integer> zigzagTraverseAndPrimes(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        HashMap<Integer, Integer> resultMap = new HashMap<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = 0, direction = 0;
        for(int i = 0; i < rows * cols; i++) {
            if(isPrime(matrix[row][col])) {
                resultMap.put(i, matrix[row][col]);
            }

            if( direction == 0) {
                if(col == cols-1) {
                    row += 1;
                    direction = 1;
                } else {
                    col += 1;
                }
            } else {
                if(col == 0) {
                    row += 1;
                    direction = 0;
                } else {
                    col -= 1;
                }
            }
        }

        return resultMap;
    }
}