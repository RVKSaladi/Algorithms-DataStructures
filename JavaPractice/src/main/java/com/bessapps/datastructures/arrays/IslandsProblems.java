package com.bessapps.datastructures.arrays;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

class Island {
    int[][] myArray;

    public Island(int row, int col) {
        myArray = new int[row][col];
        initializeArray(myArray);
    }

    public void initializeArray() {
        //Initializing the array
        for(int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray[0].length; j++) {
                myArray[i][j] = new Random().nextInt(2);
            }
        }
    }

    public void initializeArray(int[][] arr) {
        //Initializing the array
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = new Random().nextInt(2);
            }
        }
    }

    public void printArray() {
        for(int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray[0].length; j++) {
                System.out.print(myArray[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getNumberOfIslands() {
        int row = myArray.length;
        int col = myArray[0].length;

        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(myArray[i][j] == 1) {
                    count++;
                    searchPerimeter(i, j);
                }
            }
        }
        return count;
    }

    public void searchPerimeter(int rowGrid, int colGrid) {
        if(rowGrid < 0 || rowGrid >= myArray.length
                || colGrid < 0 || colGrid >= myArray[0].length
                || myArray[rowGrid][colGrid] == 0) return;

        myArray[rowGrid][colGrid] = 0;
        searchPerimeter(rowGrid-1, colGrid);
        searchPerimeter(rowGrid+1, colGrid);
        searchPerimeter(rowGrid, colGrid-1);
        searchPerimeter(rowGrid, colGrid+1);
    }

    public int getBiggestIsland() {
        int max = 0;
        for(int i = 0; i < myArray.length; i++) {
            for(int j = 0; j < myArray[0].length; j++) {
                if(myArray[i][j] == 1) {
                    int temp = getIslandGridCount(i, j);
                    max = Math.max(max, temp);
                    //System.out.println(max);
                }
            }
        }
        return max;
    }

    public int[][] getDuplicateArray(int[][] array) {
        int RC = array.length;
        int CC = array[0].length;

        int[][] temp = new int[RC][CC];

        for(int i = 0; i < RC; i++) {
            for(int j = 0; j < CC; j++) {
                temp[i][j] = myArray[i][j];
            }
        }
        return temp;
    }

    public int getIslandGridCount(int rowGrid, int colGrid) {
        int count = 0;
        if(rowGrid < 0 || rowGrid >= myArray.length
                || colGrid < 0 || colGrid >= myArray[0].length) return 0;

        if(myArray[rowGrid][colGrid] == 0) {
            return 0;
        } else {
            myArray[rowGrid][colGrid] = 0;
            count = 1;
        }
        count += getIslandGridCount(rowGrid-1, colGrid);
        count += getIslandGridCount(rowGrid+1, colGrid);
        count += getIslandGridCount(rowGrid, colGrid-1);
        count += getIslandGridCount(rowGrid, colGrid+1);
        return count;
    }

    // Making Largest Island
    public int largestIsland(int[][] grid) {
        int N = grid.length;
        int ans = 0;
        boolean hasZero = false;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 0) {
                    hasZero = true;
                    grid[r][c] = 1;
                    ans = Math.max(ans, check(grid, r, c));
                    grid[r][c] = 0;
                }

        return hasZero ? ans : N*N;
    }

    public int check(int[][] grid, int r0, int c0) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int N = grid.length;
        Stack<Integer> stack = new Stack();
        Set<Integer> seen = new HashSet();
        stack.push(r0 * N + c0);
        seen.add(r0 * N + c0);

        while (!stack.isEmpty()) {
            int code = stack.pop();
            int r = code / N, c = code % N;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                System.out.println(seen);
                if (!seen.contains(nr * N + nc) && 0 <= nr && nr < N &&
                        0 <= nc && nc < N && grid[nr][nc] == 1) {
                    stack.push(nr * N + nc);
                    seen.add(nr * N + nc);
                }
            }
        }
        return seen.size();
    }

    public int getBiggestIslandV2(int[][] tArray) {
        int max = 0;
        for(int i = 0; i < tArray.length; i++) {
            for(int j = 0; j < tArray[0].length; j++) {
                if(tArray[i][j] == 0) {
                    tArray[i][j] = 1;
                    int temp = getIslandGridCountV2(tArray, i, j);
                    System.out.println();
                    max = Math.max(max, temp);
                    tArray[i][j] = 0;
                } else {
                    int temp = getIslandGridCountV2(tArray, i, j);
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }

    public int getIslandGridCountV2(int[][] tArray, int rowGrid, int colGrid) {
        int count = 0;
        if(rowGrid < 0 || rowGrid >= tArray.length
                || colGrid < 0 || colGrid >= tArray[0].length) return 0;
        if(tArray[rowGrid][colGrid] == 0) {
            return 0;
        } else {
            count++;
        }

        tArray[rowGrid][colGrid] = 0;
        count += getIslandGridCountV2(tArray,rowGrid-1, colGrid);
        count += getIslandGridCountV2(tArray, rowGrid+1, colGrid);
        count += getIslandGridCountV2(tArray, rowGrid, colGrid-1);
        count += getIslandGridCountV2(tArray, rowGrid, colGrid+1);
        System.out.print("[" + rowGrid + "," + colGrid + "](" + tArray[rowGrid][colGrid] + "," + count + "), ");
        return count;
    }

    public void setMyArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                myArray[i][j] = arr[i][j];
            }
        }
    }
}

public class IslandsProblems {
    public static void main(String[] args) {
        Island island = new Island(2, 2);
        //island.printArray();

        /*
        int numOfIslands = island.getNumberOfIslands();
        System.out.println("Number of Islands in the Grid: " + numOfIslands);
        */

        /*
        int bigIslandSize = island.getBiggestIsland();
        System.out.println("Biggest Island size: " + bigIslandSize);
        */
        /*
        int x = island.largestIsland(island.myArray);
        System.out.println("(Making Largest island) length: " + x);
        */
        //island.printArray(dupArray);
        int[][] dupArray = new int[2][2];
        dupArray[0][0] = 1;
        dupArray[0][1] = 0;
        dupArray[1][0] = 0;
        dupArray[1][1] = 1;
        island.printArray(dupArray);
        int y = island.getBiggestIslandV2(dupArray);
        //island.printArray(dupArray);
        System.out.println("BiggestArray (v2): " + y);
    }
}
