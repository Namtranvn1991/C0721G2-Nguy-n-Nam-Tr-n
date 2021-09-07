package _4_class_and_object_in_java.execise.testStopWatch;

import java.time.LocalTime;
import java.util.Scanner;

public class TestStopWatch {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter anything to start");
        input.nextLine();
        StopWatch stopWatch = new StopWatch();
        System.out.println(stopWatch.starTime);
        System.out.println("Enter anything to stop");
        input.nextLine();
        stopWatch.stop();
        System.out.println(stopWatch.endTime);
        System.out.println(stopWatch.getElapsedTime() + " seconds");
    }
}

