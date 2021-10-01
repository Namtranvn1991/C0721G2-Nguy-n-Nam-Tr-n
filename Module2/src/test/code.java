package test;
import java.util.*;
public class code {
    public static void main(String[] args) {

        String regex = "(SV)(VL||HO||RO)-\\d{4}";
        String a = "1";
        System.out.println(a.matches(regex));
    }
}
