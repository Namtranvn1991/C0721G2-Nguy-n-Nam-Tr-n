package _12_java_collection_framework.practice.comparison_hashmap_and_hashset;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Student, Integer> studentMap = new LinkedHashMap<>();
        studentMap.put(new Student("Ha", 22, "HN"), 34);
        studentMap.put(new Student("Ha", 22, "HN"), 34);
        studentMap.put(new Student("Nam", 20, "HN"), 1);
        studentMap.put(new Student("Hung", 21, "HN"), 3);

        studentMap.forEach((k,v)-> System.out.println(k.hashCode() + ":"+ k));
    }


}