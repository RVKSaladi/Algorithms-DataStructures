package com.bessapps.datastructures.matrices;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class MatrixExample4 {

    public static void main(String args[]) {
        int[][] matrixA = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] matrixB = {
                {11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22}
        };

        MatrixExample4 matrix = new MatrixExample4();
        List<Integer> aa = matrix.matrixBoundaryConcatenation(matrixA, matrixB, 2);
    }

    public List<Integer> matrixBoundaryConcatenation(int[][] matrixA, int[][] matrixB, int n) {
        // TODO: implement the function that extracts 'n' boundary layers from matrixA and matrixB,
        // merges them into a single list and then returns this new list.
        printMatrix(matrixA);
        List<Integer> resultListA = fetchDataByClockWiseInSpiral(matrixA);
        printMatrix(matrixB);
        List<Integer> resultListB = fetchDataByClockWiseInSpiral(matrixB);
        resultListA.addAll(resultListB);

        System.out.println("Result: ");
        resultListA.forEach((x) -> System.out.print(x + " "));
        System.out.println();

        return resultListA;
    }

    public void printMatrix(int[][] matrix) {
        System.out.println("---------------------------");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public List<Integer> fetchDataByClockWiseInSpiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> dirMap = new HashMap<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = 0;
        int direction  = 0;  // 0 -> left to right; 1 -> up to down; 2 -> right to left; 3 -> down to up;

        for(int index = 0; index < rows * cols; index++) {
            result.add(matrix[row][col]);
            if(direction == 0) {  // left to right
                int tempVal = 0;
                if(dirMap.containsKey(1)) {
                    tempVal = dirMap.get(1);
                }
                if(col == cols -1-tempVal) {
                    row += 1;
                    dirMap.put(direction, dirMap.getOrDefault(direction, 0)+1);
                    direction = 1;
                } else {
                    col += 1;
                }
            } else if (direction == 1) { // up to down
                int tempVal = 0;
                if(dirMap.containsKey(2)) {
                    tempVal = dirMap.get(2);
                }
                if(row == rows -1 - tempVal) {
                    col -= 1;
                    dirMap.put(direction, dirMap.getOrDefault(direction, 0)+1);
                    direction = 2;
                } else {
                    row += 1;
                }
            } else if (direction  == 2) { // right to left
                int tempVal = 0;
                if(dirMap.containsKey(3)) {
                    tempVal = dirMap.get(3);
                }
                if(col == 0+tempVal) {
                    row -= 1;
                    dirMap.put(direction, dirMap.getOrDefault(direction, 0)+1);
                    direction = 3;
                } else {
                    col -= 1;
                }
            } else {   // down to up
                int tempVal = 0;
                if(dirMap.containsKey(0)) {
                    tempVal = dirMap.get(0);
                }
                if(row == 0 + tempVal) {
                    col += 1;
                    dirMap.put(direction, dirMap.getOrDefault(direction, 0)+1);
                    direction = 0;
                } else {
                    row -= 1;
                }
            }
        }

        return result;
    }
}