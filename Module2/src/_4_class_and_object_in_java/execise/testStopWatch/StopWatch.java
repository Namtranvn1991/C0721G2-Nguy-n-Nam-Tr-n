package _4_class_and_object_in_java.execise.testStopWatch;

import java.time.LocalTime;

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
