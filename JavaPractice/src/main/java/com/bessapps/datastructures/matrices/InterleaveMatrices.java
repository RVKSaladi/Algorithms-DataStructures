package com.bessapps.datastructures.matrices;


public class InterleaveMatrices {
    public static int[][] interleaveMatrices(int[][] matrixA, int[][] matrixB, int[][] submatrixCoords) {
        // TODO: Implement the solution here.

        printMatrix(matrixA);
        printMatrix(matrixB);
        printMatrix(submatrixCoords);

        int startRowA = submatrixCoords[0][0];
        int endRowA = submatrixCoords[0][1];
        int startColA = submatrixCoords[0][2];
        int endColA = submatrixCoords[0][3];
        int startRowB = submatrixCoords[1][0];
        int endRowB = submatrixCoords[1][1];
        int startColB = submatrixCoords[1][2];
        int endColB = submatrixCoords[1][3];

        int numRows = endRowA - startRowA + 1;
        int numColsA = endColA - startColA + 1;
        int numColsB = endColB - startColB + 1;

        int[][] subMatrixA = new int[numRows][numColsA];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColsA; j++) {
                subMatrixA[i][j] = matrixA[startRowA+i][startColA+j];
            }
        }
        printMatrix(subMatrixA);

        int[][] subMatrixB = new int[numRows][numColsB];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColsB; j++) {
                subMatrixB[i][j] = matrixB[startRowB+i][startColB+j];
            }
        }
        printMatrix(subMatrixB);

        // Matrix interleaving method,, ****
        int[][] resultMatrix = new int[numRows][numColsA + numColsB];
        for (int i = 0; i < numRows; i++) {
            int colIndex = 0;
            for (int j = 0; j < numColsA; j++) {
                resultMatrix[i][colIndex++] = subMatrixA[i][j];
                resultMatrix[i][colIndex++] = subMatrixB[i][j];
            }
        }

        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("-----------------------------");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        int[][] matrixA = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] matrixB = {
                {-11, -12, -13},
                {-14, -15, -16},
                {-17, -18, -19}
        };

        int[][] submatrixCoords = {
                {1, 2, 1, 2},
                {0, 1, 0, 1}
        };

        int[][] result = interleaveMatrices(matrixA, matrixB, submatrixCoords);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}