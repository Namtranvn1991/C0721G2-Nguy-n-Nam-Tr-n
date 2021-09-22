package _15_exception_handling_and_debug.exercise;

public class TriangleException extends Exception{
    private String error;

    public TriangleException() {
    }

    public TriangleException(String message) {
        super(message);
    }
}
