package _02_Loop_in_Java.Exercise;

public class First20PrimeNumber {
    public static void main(String[] args) {
        int n = 0;
        int number = 2;
        boolean flag = true;
        System.out.printf("First 20 prime number \n");
        while (n < 20) {
            flag = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf("%s ", number);
                n++;
            }
            number++;
        }

    }
}
