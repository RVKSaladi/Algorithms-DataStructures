package com.bessapps.datastructures.jsonstrings;

import java.util.HashMap;
import java.util.Map;

public class ParseJsonExample1 {

    public static void main(String args[]) {
        String json = "{\"key1\": \"value1\", \"key2\": {\"key3\": \"value3\", \"key4\": \"value4\"}, \"key5\": \"value5\"}";
        String updateValue = "new_value";
        System.out.println(json);
        Map<String, Map<String, String>> result = solution(json, updateValue);

        result.forEach((k, v) -> {
            System.out.print(k + " ");
            v.forEach((key, value) -> {
                System.out.println(key + " --> " + value);
            });
        });

    }
    public static Map<String, Map<String, String>> solution(String jsonString, String updateValue) {
        Map<String, Map<String, String>> result = new HashMap<>();
        jsonString = jsonString.trim();
        if (jsonString.startsWith("{") && jsonString.endsWith("}")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1).trim();
        }

        int i = 0;
        while (i < jsonString.length()) {
            // Parse key
            while (i < jsonString.length() && jsonString.charAt(i) != '"') i++;
            int keyStart = ++i;
            while (i < jsonString.length() && jsonString.charAt(i) != '"') i++;
            String key = jsonString.substring(keyStart, i);
            i++; // skip closing quote

            while (i < jsonString.length() && jsonString.charAt(i) != ':') i++; i++; // skip :

            while (i < jsonString.length() && jsonString.charAt(i) == ' ') i++;

            if (i < jsonString.length() && jsonString.charAt(i) == '"') {
                // Simple value
                int valStart = ++i;
                while (i < jsonString.length() && jsonString.charAt(i) != '"') i++;
                String val = jsonString.substring(valStart, i);
                i++;

                Map<String, String> singleMap = new HashMap<>();
                singleMap.put(key, val);
                result.put(key, singleMap);
            } else if (i < jsonString.length() && jsonString.charAt(i) == '{') {
                // Nested object
                int braceCount = 1;
                int nestedStart = ++i;
                while (i < jsonString.length() && braceCount > 0) {
                    if (jsonString.charAt(i) == '{') braceCount++;
                    else if (jsonString.charAt(i) == '}') braceCount--;
                    i++;
                }

                if (i <= jsonString.length()) {
                    String nested = jsonString.substring(nestedStart, i - 1);
                    Map<String, String> nestedMap = new HashMap<>();

                    for (String entry : nested.split(",")) {
                        String[] parts = entry.split(":", 2); // use limit=2
                        if (parts.length == 2) {
                            String k = parts[0].trim().replaceAll("\"", "");
                            String v = parts[1].trim().replaceAll("\"", "");
                            nestedMap.put(k, v);
                        }
                    }

                    result.put(key, nestedMap);
                }
            }

            while (i < jsonString.length() && (jsonString.charAt(i) == ',' || jsonString.charAt(i) == ' ')) i++;
        }

        return result;
    }
}
