package com.bessapps.datastructures.arraylists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListExample {

    public static void main(String args[]) {

        int B[] = { -1, 4, 2, 7, 23, 2, 34, 12, -4, 42 };
        sortTheArray(B);
    }

    private static void sortTheArrayAndPrintMapVersion(int[] b) {
        Map<Integer, Integer> mapX = new HashMap<>();
        for(int i = b.length-1; i >= 0; i--) {
            mapX.put(i, b[i]);
        }

        mapX.forEach((k, v) -> {
            System.out.print(k + " --> " + v + "  ");
        });
        System.out.println();
    }

    private static void sortTheArrayAndPrint(int[] b) {

        List<SimpleEntry<Integer, Integer>> sortedArray = new ArrayList<>();

        for(int i = 0; i < b.length; i++) {
            sortedArray.add(new SimpleEntry<>(i, b[i]));
        }

        for(Map.Entry<Integer, Integer> entry: sortedArray) {
            System.out.print(entry.getKey() + " --> " + entry.getValue() + "  ");
        }
        System.out.println();
    }

    private static void sortTheArray(int[] b) {

        List<SimpleEntry<Integer, Integer>> sortedArray = new ArrayList<>();

        for(int i = 0; i < b.length; i++) {
            sortedArray.add(new SimpleEntry<>(i, b[i]));
        }

        for(int i = 0; i < b.length; i++) {
            System.out.println("==> " +  sortedArray.get(i) + " ** "
                    + sortedArray.get(i).getKey() + " -- "
                              + sortedArray.get(i).getValue());
        }
    }
}
