package _4_class_and_object_in_java.execise.test_stop_watch;

import java.time.LocalTime;

class StopWatch {
    private LocalTime starTime = LocalTime.now();
    private LocalTime endTime = LocalTime.now();

    public void start() {
        this.starTime = LocalTime.now();
    }

    public void stop() {
        this.endTime = LocalTime.now();
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }


    public double getElapsedTime() {
        double elapsedHour = endTime.getHour() - starTime.getHour();
        double elapsedMinute = endTime.getMinute() - starTime.getMinute();
        double elapsedSecond = endTime.getSecond() - starTime.getSecond();
        double elapsedMillisecond = (endTime.getNano() - starTime.getNano()) / 1000000;
        double elapsed = elapsedHour * 3600 + elapsedMinute * 60 + elapsedSecond;
        return elapsed + elapsedMillisecond / 1000;
    }
}
