package _11_dsa_stack_queue.exercise.count_the_number_of_occurrences_of_each_word;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "aa aa, mm ss ww, co co ww";
        System.out.println(str);
        System.out.println(countFrequency(str).toString());

    }

    static Map<String, Integer> countFrequency(String str) {
        str = str.replace(",", "");
        String[] arr = str.split(" ");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.replace(arr[i], map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        return map;
    }

}
