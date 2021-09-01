package _02_loop_in_java.exercise;

public class PrimesLessThan100 {
    public static void main(String[] args) {
        int number = 2;
        boolean flag = true;
        System.out.printf("Prime number less than 100 \n");
        while (number < 100) {
            flag = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf("%s ", number);
            }
            number++;
        }

    }
}
