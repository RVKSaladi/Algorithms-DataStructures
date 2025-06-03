package com.bessapps.datastructures.algohashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExampleOne {
    public static void main(String args[]) {
//        ExampleOne exampleOne = new ExampleOne();
//        exampleOne.comparatorExample();

//        App app = new App();
//        String log = "1 fail 09:00, 1 solve 10:00 50, 2 solve 11:00 60, 3 solve 12:00 70, 2 fail 13:00, 3 fail 14:00";
//        app.analyzeCompetition(log);
        test();

    }

    public static void test() {
        String[] x = {"radf", "sdfs"};
        System.out.println(Arrays.toString(x));

        List<Integer[]> result = new ArrayList<>();
    }

    public void comparatorExample() {
        List<String> myList = new ArrayList<>();
        myList.add("asdtesta 1");
        myList.add("tsdfsestb 2");
        myList.add("tgsdaestc 3");
        myList.add("hsdtestd 4");
        myList.add("dhscteste 5");
        myList.add("tshasestf 6");
        myList.add("xdfgtestg 7");
        myList.add("t3sftesth 8");

        myList.sort((a, b) -> {
            int countA = Integer.parseInt(a.split(" ")[1]);
            int countB = Integer.parseInt(b.split(" ")[1]);
            if (countA != countB) {
                return Integer.compare(countB, countA); // Descending count
            }
            return a.split(" ")[0].compareTo(b.split(" ")[0]); // Ascending email
        });
        System.out.println(myList.toString());
    }
}


class App {
    public List<int[]> analyzeCompetition(String logs) {
        // TODO: implement the function
        System.out.println("====> " + logs);
        List<String> tempList = Arrays.asList(logs.split(","));
        List<int[]> resultList = new ArrayList<>();
        HashMap<String, String> myMap = new HashMap<>();
        for(String x: tempList) {
            String[] tempArray = x.trim().split(" ");
            String key = tempArray[0] + " " + tempArray[1];
            if(tempArray[1].equals("solve")) {
                myMap.put(key, myMap.getOrDefault(key, tempArray[3]));
            } else {
                myMap.put(key, myMap.getOrDefault(key, ""));
            }
        }

        HashMap<Integer, Integer[]> resultMap = new HashMap<>();
        myMap.forEach((k, v) -> {
            String[] kArray = k.split(" ");
            Integer key = Integer.parseInt(kArray[0]);
            if(kArray[1].equals("solve")) {
                if(resultMap.containsKey(key)) {
                    Integer[] array = resultMap.get(key);
                    array[1] = array[1] + Integer.parseInt(v);
                    array[2] = array[2] + 1;
                    resultMap.put(key, array);
                } else {
                    Integer[] array = new Integer[4];
                    array[0] = Integer.parseInt(kArray[0]);
                    array[1] = 0;
                    array[2] = 1;
                    array[3] = 0;
                    resultMap.put(key, array);
                }
            } else {
                if(resultMap.containsKey(key)) {
                    Integer[] array = resultMap.get(key);
                    array[3] = array[3] + 1;
                    resultMap.put(key, array);
                } else {
                    Integer[] array = new Integer[4];
                    array[0] = Integer.parseInt(kArray[0]);
                    array[1] = 0;
                    array[2] = 0;
                    array[3] = 1;
                    resultMap.put(key, array);
                }
            }

        });

        resultMap.forEach((k, v) -> {
            System.out.print(k + " --> ");
            for(int x:  v) {
                System.out.print(x + ", ");
            }
            System.out.println();
        });

        return new ArrayList<>();
    }
}
