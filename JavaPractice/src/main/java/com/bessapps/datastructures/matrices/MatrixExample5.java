package com.bessapps.datastructures.matrices;

import java.util.Arrays;

public class MatrixExample5 {

    public static void main(String args[]) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[] s1 = {0, 2, 0, 2};
        int[] s2 = {3, 5, 0, 2};
        MatrixExample5 matrix5 = new MatrixExample5();
        matrix5.submatrixSwap(matrix, s1, s2);
    }

    public void submatrixSwap(int[][] matrix, int[] coord_S1, int[] coord_S2) {
        // TODO: Implement the function that swaps coord_S1 and coord_S2 in the matrix

        int s1RowIndex = coord_S1[0];
        int s1RowLength = coord_S1[1];
        int s1ColIndex = coord_S1[2];
        int s1ColLength = coord_S1[3];
        int s2RowIndex = coord_S2[0];
        int s2RowLength = coord_S2[1];
        int s2ColIndex = coord_S2[2];
        int s2ColLength = coord_S2[3];

        System.out.println(Arrays.toString(coord_S1));
        System.out.println(Arrays.toString(coord_S2));
        System.out.println("-----------------------\n");
        printMatrix(matrix);

        System.out.println("----------AFTER-------------\n");
        for(int r1 = s1RowIndex, r2 = s2RowIndex; r1 < s1RowLength && r2 < s2RowLength; r1++, r2++) {
            for(int c1 = s1ColIndex, c2 = s2ColIndex; c1 < s1ColLength && c2 < s2ColLength; c1++, c2++) {
                int x = matrix[r1][c1];
                int y = matrix[r2][c2];
                matrix[r1][c1] = y;
                matrix[r2][c2] = x;
            }
        }
        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

}