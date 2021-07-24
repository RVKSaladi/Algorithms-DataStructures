package com.bessapps.datastructures.hashtables;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    Map<String, Integer> wordMap = new HashMap<>();

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public void setWordMap(String word, int count) {
        wordMap.put(word, count);
    }

    public Integer getCount() {
        return wordMap.size();
    }

    public void printMap() {
        for(Map.Entry<String, Integer> ent: wordMap.entrySet()) {
            System.out.println(ent.getKey() + " - " + ent.getValue());
        }
    }
}

class WordCountApplication {

    public static void main(String[] args) {
        run();
        System.out.println("done");

        /*  // Use Control D to terminate in linux...
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String s = scan.nextLine();
            if(s == "") System.out.println("null");
            else System.out.println(s);
        }
        System.out.println("Done!!!");
        */
    }

    public static void run() {
        WordCount wC = new WordCount();
        Scanner scan = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");

        while(scan.hasNext()) {
            String str = scan.next();
            Integer count = wC.getWordMap().get(str);
            if (count == null) count = 0;
            wC.getWordMap().put(str, count + 1);
        }

        int maxCount = 0;
        String maxWord = "no word";

        for(Map.Entry<String, Integer> ent : wC.getWordMap().entrySet()) {
            if(ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }

        System.out.println("Frequent word: " + maxWord);
        System.out.println("Number of times used: " + maxCount);

        wC.printMap();

    }


}