package _4_class_and_object_in_java.execise;

import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class TestStopWatch {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter anything to start");
        input.nextLine();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.starTime);
        System.out.println("Enter anything to stop");
        input.nextLine();
        stopWatch.stop();
        System.out.println(stopWatch.endTime);
        System.out.println(stopWatch.getElapsedTime() + " seconds");
    }
}

class StopWatch{
    LocalTime starTime = LocalTime.now();
    LocalTime endTime = LocalTime.now();

    void start(){
        this.starTime = LocalTime.now();
    }
    void stop(){
        this.endTime = LocalTime.now();
    }

    int getElapsedTime(){
        int elapsedHour = endTime.getHour() - starTime.getHour();
        int elapsedMinute = endTime.getMinute() - starTime.getMinute();
        int elapsedSecond = endTime.getSecond() - starTime.getSecond();
        return elapsedHour*3600 + elapsedMinute*60 + elapsedSecond;
    }

}
