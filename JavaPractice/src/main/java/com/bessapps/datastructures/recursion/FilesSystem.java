package com.bessapps.datastructures.recursion;

import java.io.File;

public class FilesSystem {
    public static void main(String args[]) {
        System.out.println(fileUsage(new File("./")));
    }

    public static long fileUsage(File root) {
        long total = root.length();
        if(root.isDirectory()) {
            for(String childName: root.list()) {
                total += fileUsage(new File(root, childName));
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }
}
