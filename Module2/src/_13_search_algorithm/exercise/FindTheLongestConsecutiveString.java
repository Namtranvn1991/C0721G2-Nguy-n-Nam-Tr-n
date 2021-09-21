package _13_search_algorithm.exercise;

import java.util.ArrayList;

public class FindTheLongestConsecutiveString {
    public static void main(String[] args) {
        String str= "abdcadghabmnxyz";
        System.out.println(search(str));
    }

    static String search(String str){
        String result= "";
        ArrayList<Character> listMax = new ArrayList<>();
        listMax.add('0');
        for (int i = 0; i < str.length() ; i++) {
            ArrayList<Character> listTemp = new ArrayList<>();
            listTemp.add(str.charAt(i));
            for (int j = i+1; j < str.length() ; j++) {
                if (str.charAt(j - 1) < str.charAt(j)){
                    listTemp.add(str.charAt(j));
                } else {
                    break;
                }
            }
            if (listTemp.size()>listMax.size()){
                listMax = (ArrayList<Character>) listTemp.clone();
            }
        }
        for (Character character: listMax) {
            result += character;
        }
        return result;
    }
}
