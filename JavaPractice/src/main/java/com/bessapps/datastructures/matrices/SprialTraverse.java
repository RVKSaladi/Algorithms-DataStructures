package com.bessapps.datastructures.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprialTraverse {

    public static void main(String args[]) {
        char[][] grid = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        SprialTraverse sprialTraverse = new SprialTraverse();
        int[] temp = sprialTraverse.spiralTraverseAndVowels(grid);

    }

    public int[] spiralTraverseAndVowels(char[][] grid) {
        // TODO: implement
        int[] sequenceArray = traverseMatrix(grid);
        return sequenceArray;
    }

    public int[] traverseMatrix(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        String VOWELS = "aeiouAEIOU";

        int row = 0, col = 0, direction  = 0; // direction 0 -> left - right, 1 -> up -> down, 2 - right -> left; 3 down -> up;
        List<Character> traverseList = new ArrayList<>();
        Map<String, Integer> directionMap = new HashMap<>();

        for(int i = 0; i < rows * cols; i++) {
            if(direction == 0) {
                traverseList.add(grid[row][col]);
                int tempVal = 0;
                if(directionMap.containsKey("up-down")) {
                    tempVal = directionMap.get("up-down");
                }
                if(col == cols-1-tempVal) {
                    row += 1;
                    direction = 1;
                    directionMap.put("left-right", directionMap.getOrDefault("left-right", 0)+1);
                } else {
                    col += 1;
                }
            } else if(direction == 1) {
                traverseList.add(grid[row][col]);
                int tempVal = 0;
                if(directionMap.containsKey("right-left")) {
                    tempVal = directionMap.get("right-left");
                }
                if(row == rows-1-tempVal) {
                    direction = 2;
                    col -= 1;
                    directionMap.put("up-down", directionMap.getOrDefault("up-down", 0)+1);
                } else {
                    row += 1;
                }
            } else if( direction == 2) {
                traverseList.add(grid[row][col]);
                int tempVal = 0;
                if(directionMap.containsKey("down-up")) {
                    tempVal = directionMap.get("down-up");
                }
                if(col == 0+tempVal) {
                    direction  = 3;
                    row -= 1;
                    directionMap.put("right-left", directionMap.getOrDefault("right-left", 0)+1);
                } else {
                    col -= 1;
                }
            } else {
                traverseList.add(grid[row][col]);
                int tempVal = 0;
                if(directionMap.containsKey("left-right")) {
                    tempVal = directionMap.get("left-right");
                }
                if(row == 0+tempVal) {
                    direction = 0;
                    col += 1;
                    directionMap.put("down-up", directionMap.getOrDefault("down-up", 0)+1);
                } else {
                    row -= 1;
                }

            }
        }

        List<Integer> resultArray = new ArrayList<>();
        for(int i = 0; i < traverseList.size(); i++) {
            if(VOWELS.indexOf(traverseList.get(i)) != -1) {
                resultArray.add(i);
            }
        }
        int[] resultArray1 = resultArray.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(resultArray1));
        return resultArray1;
    }
}