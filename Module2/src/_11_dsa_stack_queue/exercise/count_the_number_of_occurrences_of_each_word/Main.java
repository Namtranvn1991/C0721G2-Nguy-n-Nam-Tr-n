package _11_dsa_stack_queue.exercise.count_the_number_of_occurrences_of_each_word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String str = "a aa mm ss ww co co ww";
        System.out.println(countFrequency(str).toString());
    }

    static Map<String,Integer> countFrequency(String str){
        String [] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        Map<String,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            int count = 0;
            for (int j =0;j<arr.length;j++){
                if (arr[i].equals(arr[j])){
                    count ++;
                }
            }
            map.put(arr[i],count);
        }
        return map;
    }
}
