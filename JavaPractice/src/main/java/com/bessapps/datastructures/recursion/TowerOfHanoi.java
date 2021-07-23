package com.bessapps.datastructures.recursion;

public class TowerOfHanoi {

    public static void moveTowerOfHanoi(int diskNumber,  char from_rod, char to_rod, char temp_rod) {
        if(diskNumber == 1) {
            System.out.println("*Move disk " + diskNumber + " from " + from_rod + " to " + to_rod);
            return;
        } else {
            moveTowerOfHanoi(diskNumber-1, from_rod, temp_rod, to_rod);
            System.out.println("Move disk " + diskNumber + " from " + from_rod + " to " + to_rod);
            moveTowerOfHanoi(diskNumber-1, temp_rod, to_rod, from_rod);
        }
    }

    public static void main(String args[]) {
        int N = 3;
        moveTowerOfHanoi(N, 'A', 'B', 'T');
    }
}
