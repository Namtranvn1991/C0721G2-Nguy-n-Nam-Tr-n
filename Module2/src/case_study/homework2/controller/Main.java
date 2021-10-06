package case_study.homework2.controller;

import case_study.homework2.model.Receipt;
import case_study.homework2.service.CustomerService;
import case_study.homework2.service.ReceiptService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        while (true) {
            System.out.println("1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                    "7. Thoát\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addCustomer();
                    break;
                case "2":
                    displayCustomers();
                    break;
                case "3":
                    searchCustomer();
                    break;
                case "4":
                    addReceipt();
                    break;
                case "5":
                    editReceipt();
                    break;
                case "6":
                    displayReceipt();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void addCustomer() {
        System.out.println("1. them kh VN 2. them kh NN 3. Return");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                CustomerService.addCustomerVN();
                break;
            case "2":
                CustomerService.addCustomerNN();
                break;
            case "3":
                return;
            default:
                System.out.println("Please enter again");
        }
    }
    static void displayCustomers(){
        CustomerService.display();
    }

    static void searchCustomer(){
        CustomerService.search();
    }

    static void addReceipt(){
        ReceiptService.add();
    }
    static void editReceipt(){
        ReceiptService.edit();
    }
    static void displayReceipt(){
        ReceiptService.display();
        System.out.println("Do y want to display receipt detail Y/N");
        String choice = scanner.nextLine();
        switch (choice){
            case "y":
            case "Y":
                ReceiptService.displayDetail();
                break;
            default:
                return;
        }
    }
}
