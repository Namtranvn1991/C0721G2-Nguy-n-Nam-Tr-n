package _4_class_and_object_in_java.execise.test_stop_watch;

import java.time.LocalTime;
import java.util.Scanner;

public class TestStopWatch {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter anything to start");
        input.nextLine();
        StopWatch stopWatch = new StopWatch();
        System.out.println(stopWatch.getStarTime());
        System.out.println("Enter anything to stop");
        input.nextLine();
        stopWatch.stop();
        System.out.println(stopWatch.getEndTime());
        System.out.println(stopWatch.getElapsedTime() + " seconds");
    }
}

