package com.treemap;

import java.util.Iterator; // Import for Iterator
import java.util.Map;     // Import for Map.Entry
import java.util.TreeMap;

public class Demo2 {

    public static void main(String[] args) {
        // Create a TreeMap (using raw type as in your example, but generics like TreeMap<Integer, String> are recommended)
        TreeMap map = new TreeMap();

        System.out.println("1. Initial size of TreeMap: " + map.size());
        System.out.println("2. Is TreeMap empty? " + map.isEmpty());
        System.out.println("3. Contents of TreeMap before adding elements: " + map);
        System.out.println("------------------------------------");

        // Add key/value to the TreeMap
        // TreeMap stores keys in sorted order
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(5, "Five");
        map.put(4, "Four");

        // Adding a duplicate key replaces the old value
        map.put(2, "Two-Updated");

        // TreeMap does not allow null keys
        // map.put(null, "Null Key"); // This would throw a NullPointerException

        // TreeMap allows null values
        map.put(6, null);

        System.out.println("4. Size of TreeMap after adding elements: " + map.size());
        System.out.println("5. Is TreeMap empty? " + map.isEmpty());
        System.out.println("6. Contents of TreeMap after adding elements: " + map); // Keys will be sorted
        System.out.println("------------------------------------");

        // Accessing elements
        System.out.println("7. Value for key 1: " + map.get(1));
        System.out.println("8. Value for key 2: " + map.get(2)); // Will show "Two-Updated"
        System.out.println("9. Value for non-existent key 99: " + map.get(99)); // Returns null
        System.out.println("------------------------------------");

        // Checking for key/value existence
        System.out.println("10. Does map contain key 3? " + map.containsKey(3));
        System.out.println("11. Does map contain key 10? " + map.containsKey(10));
        System.out.println("12. Does map contain value 'One'? " + map.containsValue("One"));
        System.out.println("13. Does map contain value 'NonExistent'? " + map.containsValue("NonExistent"));
        System.out.println("------------------------------------");

        // Removing elements
        map.remove(4); // Remove entry with key 4
        System.out.println("14. After removing key 4: " + map);
        System.out.println("15. Size after removing key 4: " + map.size());
        System.out.println("------------------------------------");

        // --- Iterating through TreeMap using Iterator for EntrySet ---
        System.out.println("\n--- Iterating through TreeMap EntrySet with Iterator ---");
        System.out.print("Entries via Iterator: ");
        // Get an Iterator for the Set of Map.Entry objects
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) { // Check if there's a next entry
            Map.Entry entry = (Map.Entry) iterator.next(); // Get the next entry
            System.out.print("(" + entry.getKey() + "=" + entry.getValue() + ") ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");

        // --- Iterating over keys only ---
        System.out.println("\n--- Iterating through TreeMap KeySet with Iterator ---");
        System.out.print("Keys via Iterator: ");
        Iterator keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.print(key + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");

        // --- Iterating over values only ---
        System.out.println("\n--- Iterating through TreeMap Values with Iterator ---");
        System.out.print("Values via Iterator: ");
        Iterator valueIterator = map.values().iterator();
        while (valueIterator.hasNext()) {
            Object value = valueIterator.next();
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");


        // Clearing the map
        map.clear();
        System.out.println("16. After clearing the TreeMap: " + map);
        System.out.println("17. Size after clearing: " + map.size());
        System.out.println("18. Is TreeMap empty? " + map.isEmpty());
    }
}

