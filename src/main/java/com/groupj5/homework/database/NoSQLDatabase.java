package com.groupj5.homework.database;

import java.util.HashMap;
import java.util.Map;

public class NoSQLDatabase {
    private static Map<String, String> storage = new HashMap<>();

    public void putValue(String key, String object) {
        storage.put(key, object);
    }

    public String getValue(String key) {
        return storage.get(key);
    }

}
