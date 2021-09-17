package _12_java_collection_framework.exercise.using_arraylist_and_linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Menu\n" +
                    "1. Add " +
                    "2. Remove " +
                    "3. Display " +
                    "4. Edit " +
                    "5. Search " +
                    "6. Sort " +
                    "7. Exit \n");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    ProductManager.addProduct();
                    break;
                case 2:
                    ProductManager.remove();
                    break;
                case 3:
                    ProductManager.display();
                    break;
                case 4:
                    ProductManager.edit();
                    break;
                case 5:
                    ProductManager.search();
                    break;
                case 6:
                    ProductManager.sort();
                    break;
                case 7:
                    flag = false;
                    break;
            }
        }
    }
}
