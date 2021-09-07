package test.btnhom;


import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        String str = "assdddwwqds";
        String[] a= str.split("");
        System.out.println(Arrays.toString(a));

        int count =0;


        for (int i = 0; i < str.length(); i++) {
            boolean f = true;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)&& i!=j) {
                    f = false;
                }
            }
            if (f) {
                count++;
            }
        }
        System.out.println(count);
    }
}
