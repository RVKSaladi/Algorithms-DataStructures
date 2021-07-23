package com.bessapps.datastructures.arrays;

import java.util.Locale;

public class CaesarCipher {
    private static final int charSetLen = 26;
    private static final int digitSetLen = 10;
    protected char[] encoder = new char[charSetLen];
    protected char[] decoder = new char[charSetLen];

    public CaesarCipher(int rotation) {
        for(int i = 0; i < charSetLen; i++) {
            encoder[i] = (char) ('A' + (rotation+i)%charSetLen);
            decoder[i] = (char) ('A' + (i-rotation+charSetLen)%charSetLen);
        }
    }

    public void printCharacters() {
        char c = 'A';
        for(int i = 0; i < 26; i++) {
            System.out.print(c + "(" + (int)c + ") ");
            c++;
        }
        System.out.println();
        c = 'a';
        for(int i = 0; i < 26; i++) {
            System.out.print(c + "(" + (int)c + ") ");
            c++;
        }
        System.out.println();
        c = '0';
        for(int i = 0; i < 10; i++) {
            System.out.print(c + "(" + (int)c + ") ");
            c++;
        }
        System.out.println();
    }

    public char getEncodedChar(char c, int rotation) {
        int val = c;
        if(c >= 'A' && c <= 'Z') {
            val = 'A' + (c - 'A' + rotation) % 26;
        }
        return (char) val;
    }

    public char getDecodedChar(char c, int rotation) {
        int val = c;
        if(c >= 'A' && c <= 'Z') {
            val = 'A' + (c + 'A' - rotation) % 26;
        }
        return (char) val;
    }

    public String encript(String orig) {
        return transform(orig, encoder);
    }

    public String decrypt(String orig) {
        return transform(orig, decoder);
    }

    public String transform(String orig, char[] code) {
        // Edge cases
        orig = orig.toUpperCase();

        char [] charMsg = orig.toCharArray();
        for(int i = 0; i < charMsg.length; i++) {

            // Ignoring Non Alphabet characters...
            if(charMsg[i] >= 'A' && charMsg[i] <= 'Z') {
                int temp = charMsg[i] - 'A';
                charMsg[i] = code[temp];
            }
        }
        return new String(charMsg);
    }

    public String encryptWithoutUsingExternalArray(String orig, int rotation) {
        char[] charArray = orig.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            charArray[i] = getEncodedChar(charArray[i], rotation);
        }
        return new String(charArray);
    }

    public String decryptWithoutUsingExternalArray(String orig, int rotation) {
        char[] charArray = orig.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            charArray[i] = getDecodedChar(charArray[i], rotation);
        }
        return new String(charArray);
    }
}


class ApplicationTest {
    public static void main(String args[]) {
        System.out.println("Praise the Lord Jesus!");

        CaesarCipher caesarCipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(caesarCipher.encoder));
        System.out.println("Encryption code = " + new String(caesarCipher.decoder));
        //caesarCipher.printCharacters();

        String s = "PraiseTheLord****JesuForEverAndEver!!";
        /*
        String s1 = caesarCipher.encript(s);
        System.out.println(s1);
        s1 = caesarCipher.decrypt(s1);
        System.out.println(s1);
        */

        s = "ABCDXYZ";
        System.out.println("Original: " + s);
        String s1 = caesarCipher.encryptWithoutUsingExternalArray(s, 3);
        System.out.println("Encoded: " + s1);
        s1 = caesarCipher.decryptWithoutUsingExternalArray(s1, 3);
        System.out.println("Decoded: " + s1);
    }
}