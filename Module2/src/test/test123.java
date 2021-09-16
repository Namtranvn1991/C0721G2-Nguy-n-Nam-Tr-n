package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class UseMapCountElement {
    public static void main(String[] args) {
        String str = "hello words hello words hello";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            String key = arr[i];
            if (map.containsKey(key)) {
                map.replace(key,map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }
        Set<String> set = map.keySet();

        for (String sets : set) {
            System.out.println("Key: " + sets + " xuất hiện: " + map.get(sets) + " lần");
        }

    }
}

