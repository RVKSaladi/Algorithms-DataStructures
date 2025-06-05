package com.bessapps.datastructures.jsonstrings;

import java.util.HashMap;
import java.util.Map;

public class JsonStringsParsing {

    public static void main(String args[]) {

        JsonStringsParsing jsonStringsParsing = new JsonStringsParsing();
        //String input = "User1:Age1=21;Location1=USA;Preferences1={Food1=Italian;Sport1=Fencing};User2:Age2=30;Location2=Canada;Preferences2={Music2=Jazz;Color2=Blue}";
        String input = "User1:Age1=21;Location1=USA;Preferences1={Food1=Italian;Sport1=Fencing};User2:Age2=30;Location2=Canada;Preferences2=none";
        int userIndex = 1;
        String prefKey = "Sport1";
        String newValue = "Hockey";
        Map<String, Map<String, String>> myMap = jsonStringsParsing.updatePreference(input, userIndex, prefKey, newValue);
        myMap.forEach((k, v) -> {
            System.out.println(k + "----> ");
            v.forEach((key, value) -> System.out.println(key + " = " + value));
        });
    }

    public Map<String, Map<String, String>> updatePreference(String inputString, int userIndex, String prefKey, String newValue) {
        // TODO: Implement the function

        Map<String, Map<String, String>> resultMap = new HashMap<>();

        String tempString = inputString;
        String keyString = "";
        String valueString = "";
        String tempString1 = "";

        while(tempString.contains(":")) {
            int index = tempString.indexOf(":");
            keyString = tempString.substring(0, index++);
            tempString1 = tempString.substring(index, tempString.length());

            if(tempString1.contains(":")) {
                int tIndex = tempString1.indexOf(':');
                int sIndex = tempString1.substring(0, tIndex).lastIndexOf(";");
                valueString = tempString1.substring(0, sIndex);
                tempString1 = tempString1.substring(++sIndex, tempString1.length());
            } else {
                valueString = tempString1.substring(0, tempString1.length());
            }

            Map<String, String> innerMap = fetchInnerMap(valueString, prefKey, newValue);
            resultMap.put(keyString, innerMap);

            if(!tempString1.equals("")) tempString = tempString1;
        }

        resultMap.forEach((key, value) -> {
            value.forEach((k, v) -> {
                if(k.equals(prefKey)) {
                    v = newValue;
                }
            });
        });

        return resultMap;
    }

    public Map<String, String> fetchInnerMap(String valueString, String prefKey, String newValue) {
        HashMap<String, String> innerMap = new HashMap<>();

        int indexBraces = valueString.indexOf('{');
        if(indexBraces != -1) {
            String temp = valueString.substring(0, indexBraces);
            int tKeyIndex = temp.lastIndexOf(';');
            temp = temp.substring(0, tKeyIndex);
            String[] tempArray1 = temp.split(";");
            for(String x: tempArray1) {
                String[] tempArray2 = x.split("=");
                innerMap.put(tempArray2[0], tempArray2[1]);
            }

            int t = valueString.indexOf('}');
            if(t != -1) {
                String temp2 = valueString.substring(++tKeyIndex, t+1);
                int indexOfEqual = temp2.indexOf('=');
                String key = temp2.substring(0, indexOfEqual);
                String value = temp2.substring(indexOfEqual+1, temp2.length());
                if(value.contains(prefKey)) {
                    value = changeValue(value, prefKey, newValue);
                }
                innerMap.put(key, value);
            }
        } else {
            String temp = valueString;
            int tKeyIndex = temp.lastIndexOf(';');
            temp = temp.substring(0, tKeyIndex);
            String[] tempArray1 = temp.split(";");
            for(String x: tempArray1) {
                String[] tempArray2 = x.split("=");
                innerMap.put(tempArray2[0], tempArray2[1]);
            }
        }
        return innerMap;
    }

    public String changeValue(String value, String prefKey, String newValue) {
        String result = "{";
        value = value.substring(1, value.length()-1);
        String[] array = value.split(";");
        for(String x: array) {
            String[] arr = x.split("=");
            if(arr[0].equals(prefKey)) arr[1] = newValue;
            result += arr[0] + "=" + arr[1] + ";";
        }
        result = result.substring(0, result.length()-1) + "}";
        return result;
    }
}
