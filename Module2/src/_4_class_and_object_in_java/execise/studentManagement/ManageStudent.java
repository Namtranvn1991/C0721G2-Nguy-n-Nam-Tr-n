package _4_class_and_object_in_java.execise.studentManagement;

import java.util.Scanner;

public class ManageStudent {
    private static Student[] studentList = new Student[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void add() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, age);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }
    }

    public static void display() {
        int number = 1;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println((number + i) + " " + studentList[i].toString());
            } else {
                break;
            }
        }
    }

    public static void remove() {
        System.out.println("Remove menu 0. Return 1. ID  2. Name");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Remove student with Id ");
                int idRemove = scanner.nextInt();
                boolean flag1 = false;
                int index1 = 0;
                for (int i = 0; i < studentList.length; i++) {
                    if (studentList[i] != null) {
                        if (studentList[i].getId() == idRemove) {
                            studentList[i] = null;
                            index1 = i;
                            flag1 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (flag1) {
                    for (int i = index1; i < studentList.length; i++) {
                        studentList[i] = studentList[i + 1];
                        if (studentList[i] == null) {
                            break;
                        }
                    }
                } else {
                    System.out.println("The ID isn't in the List");
                }
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Remove student with name ");
                scanner.nextLine();
                String nameRemove = scanner.nextLine();
                boolean flag2 = false;
                int index2 = 0;
                for (int i = 0; i < studentList.length; i++) {
                    if (studentList[i] != null) {
                        if (studentList[i].getName().equals(nameRemove)) {
                            studentList[i] = null;
                            index2 = i;
                            flag2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (flag2) {
                    for (int i = index2; i < studentList.length; i++) {
                        studentList[i] = studentList[i + 1];
                        if (studentList[i] == null) {
                            break;
                        }
                    }
                } else {
                    System.out.println(nameRemove + " isn't in the List");
                }
                break;
            default:
                break;
        }
    }

    public static void edit() {
        System.out.println("Enter the student number you want to edit. Enter 0 to return the menu");
        int indexEdit;
        boolean flag = true;
        do {
            indexEdit = scanner.nextInt() - 1;
            scanner.nextLine();
            if (indexEdit == -1) {
                flag = false;
                break;
            }
            if (indexEdit < 0 || studentList[indexEdit] == null) {
                System.out.println("Enter the student number again");
            }
        } while (indexEdit < 0 || studentList[indexEdit] == null);
        if (!flag) {
            return;
        }
        System.out.println(studentList[indexEdit].toString());
        System.out.println("0. Return 1. Edit id  2. Edit name 3. Edit age");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter new Id");
                int newId = scanner.nextInt();
                scanner.nextLine();
                studentList[indexEdit].setId(newId);
                break;
            case 2:
                System.out.println("Enter new name");
                String newName = scanner.nextLine();
                studentList[indexEdit].setName(newName);
                break;
            case 3:
                System.out.println("Enter new age");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                studentList[indexEdit].setId(newAge);
                break;
            default:
                break;
        }
    }

    public static void search() {
        System.out.println("0. Return 1. Search id 2. Search name 3. Search age");
        int input = scanner.nextInt();
        int count = 0;
        switch (input) {
            case 1:
                System.out.println("Enter id");
                int idSearch = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0, j = 0; studentList[i] != null; i++) {
                    if (studentList[i].getId() == idSearch) {
                        System.out.println((i + 1) + "." + studentList[i].toString());
                        count++;
                    }
                }
                break;
            case 2:
                System.out.println("Enter name");
                scanner.nextLine();
                String nameSearch = scanner.nextLine();

                for (int i = 0; studentList[i] != null; i++) {
                    if (studentList[i].getName().equals(nameSearch)) {
                        System.out.println((i + 1) + "." + studentList[i].toString());
                        count++;
                    }
                }
                break;
            case 3:
                System.out.println("Enter age");
                int ageSearch = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0, j = 0; studentList[i] != null; i++) {
                    if (studentList[i].getAge() == ageSearch) {
                        System.out.println((i + 1) + "." + studentList[i].toString());
                        count++;
                    }
                }
                break;
            default:
                break;
        }
        if (count == 0) {
            System.out.println("Not found");
        }
    }
}
