package com.bessapps.datastructures.arrays;

public class CipherCoder {
    public static void main(String [] args) {

        char c = 'A';

        int x = 'A' + (c - 'A' + 3)%26;
        c = (char)x;
        int y = 'A' + (c + 'A' - 3)%26;
        System.out.println(x + " - " + y);

    }
}
