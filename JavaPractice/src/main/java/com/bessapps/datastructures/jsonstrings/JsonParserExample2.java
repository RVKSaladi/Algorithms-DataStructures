package com.bessapps.datastructures.jsonstrings;

import java.util.HashMap;

public class JsonParserExample2 {
    public static void main(String[] args) {
        //String input = "A1=B1,C1={D1=E1,F1=G1},I1=J1";
        String input = "User1:Age1=21;Location1=USA;Preferences1={Food1=Italian;Sport1=Fencing};User2:Age2=30;" +
                "Location2=Canada;Preferences2={Music2=Jazz;Color2=Blue}";
        String updateKey = "F1";
        String newValue = "NewValue";

        //HashMap<String, HashMap<String, String>> updatedMap = parseStringAndUpdateValue(input, updateKey, newValue);
        parseString(input, updateKey, newValue);
    }

    private static HashMap<String, HashMap<String, String>> parseStringAndUpdateValue(String input, String updateKey, String newValue) {

        HashMap<String, HashMap<String, String>> result = new HashMap<>();

        boolean fetchKey = false;
        boolean fetchVal = false;
        int startPos = 0;
        int i = 0;
        String key = "";
        while(i < input.length()) {
            if(!fetchVal && input.charAt(i) == ':') {
                fetchKey = true;
            } else if(!fetchKey && fetchVal) {
                //fetchKey = true;
            }

            if(fetchKey) {
                key = input.substring(startPos, i++);
                System.out.println("KEY: " + key);
                startPos = i;
                fetchVal = true;
                fetchKey = false;
            }
            i++;
        }
        return result;
    }

    private static void parseString(String input, String updateKey, String newValue) {
//        String[] strArray = input.split("");
//        for(String s: strArray) {
//            System.out.println(s);
//        }

//        int index1 = input.indexOf(':');
//        String str = input.substring(0, index1++);
//        String temp = input.substring(index1, input.length());
//        System.out.println("1: " + str);
//        index1 = temp.indexOf(':');
//        if(index1 != -1) {
//            str = temp.substring(0, index1++);
//            temp = temp.substring(index1, temp.length());
//            System.out.println("2: " + str);
//            index1 = temp.indexOf(':');
//            if(index1 != -1) {
//                str = temp.substring(0, index1++);
//                temp = temp.substring(index1, temp.length() - 1);
//                System.out.println("3: " + str);
//            } else {
//                System.out.println("Last: " + temp);
//            }
//        }

        System.out.println("\nxxxxxxxxxxxx " + input);
        int index = 0;
        String tempStr = input;


        while(tempStr.contains(":")) {
            index = tempStr.indexOf(':');
            String key = tempStr.substring(0, index++);
            tempStr = tempStr.substring(index, tempStr.length());

            String tempStr1 = "";
            String tempStr2 = "";
            if(tempStr.contains(":")) {
                int tIndex = tempStr.indexOf(':');
                int sIndex = tempStr.substring(0, tIndex).lastIndexOf(';');

                index = ++sIndex;
                tempStr1 = tempStr.substring(0, sIndex);
                tempStr2 = tempStr.substring(sIndex, tempStr.length());
            }

            if(tempStr1.equals("")) tempStr1 = tempStr;
            System.out.println("======> " + tempStr1);

            if(!tempStr2.equals("")) {
                tempStr = tempStr2;
            }
        }

    }
}
