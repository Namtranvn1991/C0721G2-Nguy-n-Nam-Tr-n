package _4_class_and_object_in_java.execise.studentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;


        while (flag){
            System.out.println("Menu\n" +
                    "1. Add \n"+
                    "2. Remove \n"+
                    "3. Display \n"+
                    "4. Edit \n"+
                    "5. Search \n"+
                    "6. Exit \n");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    manageStudent.add();
                    break;
                case 2:
                    manageStudent.remove();
                    break;
                case 3:
                    manageStudent.display();
                    break;
                case 4:
                    manageStudent.edit();
                    break;
                case 5:
                    manageStudent.search();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
    }
}
