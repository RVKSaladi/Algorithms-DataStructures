package com.bessapps.datastructures.jsonstrings;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NestedMapParser {

    public static Map<String, Map<String, String>> parseToNestedMap(String jsonStr) {
        JSONObject json = new JSONObject(jsonStr);
        Map<String, Map<String, String>> result = new HashMap<>();

        for (String key : json.keySet()) {
            Object value = json.get(key);

            if (value instanceof JSONObject) {
                JSONObject nestedJson = (JSONObject) value;
                Map<String, String> nestedMap = new HashMap<>();
                for (String nestedKey : nestedJson.keySet()) {
                    nestedMap.put(nestedKey, nestedJson.getString(nestedKey));
                }
                result.put(key, nestedMap);
            } else {
                Map<String, String> singleValueMap = new HashMap<>();
                singleValueMap.put(key, value.toString());
                result.put(key, singleValueMap);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"key1\": \"value1\", \"key2\": {\"key3\": \"value3\", \"key4\": \"value4\"}, \"key5\": \"value5\"}";

        Map<String, Map<String, String>> nestedMap = parseToNestedMap(jsonStr);

        for (Map.Entry<String, Map<String, String>> entry : nestedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
