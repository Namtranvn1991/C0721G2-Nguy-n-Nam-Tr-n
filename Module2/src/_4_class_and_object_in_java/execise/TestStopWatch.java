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
        System.out.println(stopWatch.starTime);
        System.out.println("Enter anything to stop");
        input.nextLine();
        stopWatch.stop();
        System.out.println(stopWatch.endTime);
        System.out.println(stopWatch.getElapsedTime() + " seconds");

    }


}

class StopWatch {
    LocalTime starTime = LocalTime.now();
    LocalTime endTime = LocalTime.now();

    void start() {
        this.starTime = LocalTime.now();
    }

    void stop() {
        this.endTime = LocalTime.now();
    }

    double getElapsedTime() {
        double elapsedHour = endTime.getHour() - starTime.getHour();
        double elapsedMinute = endTime.getMinute() - starTime.getMinute();
        double elapsedSecond = endTime.getSecond() - starTime.getSecond();
        double elapsedMillisecond = (endTime.getNano() - starTime.getNano()) / 1000000;
        double elapsed = elapsedHour * 3600 + elapsedMinute * 60 + elapsedSecond;
        return elapsed + elapsedMillisecond / 1000;
    }

}

class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        StopWatch stopWatch = new StopWatch();
        SelectionSort ob = new SelectionSort();
        int arr[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double randomNumber = Math.random();
            randomNumber = randomNumber * 100000 + 1;
            int randomInt = (int) randomNumber;
            arr[i] = randomInt;
        }
        stopWatch.start();
        ob.sort(arr);
        System.out.println("Sorted array");
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime() + " seconds");
    }
}
