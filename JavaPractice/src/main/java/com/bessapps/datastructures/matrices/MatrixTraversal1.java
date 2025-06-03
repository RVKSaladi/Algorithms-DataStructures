package com.bessapps.datastructures.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTraversal1 {

    public static void main(String args[]) {
        int [][] matrix = {
                {1, -2, 3, -4},
                {5, -6, 7, 8},
                {-9, 10, -11, 12}
        };
        MatrixTraversal1 m = new MatrixTraversal1();
        List<int[]> sol = m.solution(matrix);
        for(int[] x: sol) {
            System.out.println(Arrays.toString(x));
        }
    }

    public List<int[]> solution(int[][] matrix) {
        // TODO: implement
        printMatrix(matrix);

        int rows = matrix.length;
        int cols = matrix[0].length;

        ArrayList<Integer> traversal = new ArrayList<>();
        ArrayList<int[]> result = new ArrayList<>();

        int row = 0, col = 0, dir = 1;
        for(int i = 0; i < rows*cols; i++) {
            int temp = matrix[row][col];
            traversal.add(temp);
            if(temp < 0) {
                result.add(new int[] {row, col});
            }

            if(dir == 0) { // Moving left to Right
                if(row == rows - 1) {
                    col += 1;
                    dir = 1;
                } else if (col == 0) {
                    row += 1;
                    dir = 1;
                } else {
                    row += 1;
                    col -= 1;
                }
            } else {
                if( col == cols -1) {
                    row += 1;
                    dir = 0;
                } else if(row == 0) {
                    col += 1;
                    dir = 0;
                } else {
                    row -= 1;
                    col += 1;
                }
            }
        }

        return result;
    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}