package _13_search_algorithm.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        String str = "abcabcdgabmnsxya";
        System.out.println(search(str));
    }

    static String search(String str) {
        String result = "";
        LinkedList<Character> listMax = new LinkedList<>();
        listMax.add('0');
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> listTemp = new LinkedList<>();
            listTemp.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j)>listTemp.getLast()){
                    listTemp.add(str.charAt(j));
                }
            }
            if (listTemp.size() > listMax.size()) {
                listMax = (LinkedList<Character>) listTemp.clone();
            }
        }
        for (Character character : listMax) {
            result += character;
        }
        return result;
    }
}
