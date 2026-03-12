package com.ab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("D");
        arrayList.add("F");
        arrayList.add(new Integer(101));
        arrayList.add(null);
        arrayList.add("A");

        System.out.println("Original ArrayList: " + arrayList);
        arrayList.add(3, "B");
        System.out.println("After adding 'B' at index 3: " + arrayList);

        String s1 = (String) arrayList.get(3);
        System.out.println("Element at index 3: " + s1);

        arrayList.remove("F");
        System.out.println("After removing 'F': " + arrayList);

        arrayList.remove(1);
        System.out.println("After removing element at index 1: " + arrayList);

        System.out.println("\n--- Iteration Examples ---");
        System.out.println("Current ArrayList for iteration: " + arrayList);
        System.out.println("------------------------------------");

        // Using Iterator with ArrayList
        System.out.print("1.Iterator: ");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object e = iterator.next();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        // Using ListIterator with ArrayList
        System.out.print("2.ListIterator forward: ");
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            Object e = listIterator.next();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        System.out.print("3.ListIterator backward: ");
        while (listIterator.hasPrevious()) {
            Object e = listIterator.previous();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
}
