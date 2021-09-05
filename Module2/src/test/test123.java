package test;

import java.time.LocalTime;

public class test123 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        double a = time.getNano()/1000000;
        System.out.println(a);
    }
}