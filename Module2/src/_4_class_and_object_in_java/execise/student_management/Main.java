package _4_class_and_object_in_java.execise.student_management;

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
                    "6. Exit \n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    ManageStudent.add();
                    break;
                case 2:
                    ManageStudent.remove();
                    break;
                case 3:
                    ManageStudent.display();
                    break;
                case 4:
                    ManageStudent.edit();
                    break;
                case 5:
                    ManageStudent.search();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
    }
}
