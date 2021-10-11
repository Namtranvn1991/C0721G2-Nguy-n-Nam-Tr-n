package controller;

import model.ShortTermNoLimitPB;
import service.LongTermPBService;
import service.ShortTermPBService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        while (true) {
            System.out.println("*************************");
            System.out.println("1. Thêm mới sổ tiết kiệm\n" +
                    "2. Xóa sổ tiết kiệm\n" +
                    "3. Xem danh sách sổ tiết kiệm\n" +
                    "4. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    remove();
                    break;
                case "3":
                    display();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void add(){
        while (true){
            System.out.println("1. dai han 2. ngan han 3. return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    LongTermPBService.add();
                    break;
                case "2":
                    addShort();
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }

    static void display(){
        while (true){
            System.out.println("1. dai han 2. ngan han 3.return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    LongTermPBService.display();
                    break;
                case "2":
                    ShortTermPBService.display();
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }
    static void remove(){
        while (true){
            System.out.println("1. dai han 2. ngan han 3.return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    LongTermPBService.remove();
                    break;
                case "2":
                    ShortTermPBService.remove();
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }
    static void addShort(){
        while (true){
            System.out.println("1. Limit 2. NoLimit 3.return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    ShortTermPBService.addLimit();
                    break;
                case "2":
                    ShortTermPBService.addNoLimit();
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }
}
