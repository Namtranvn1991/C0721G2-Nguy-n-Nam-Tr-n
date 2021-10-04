package case_study.furama.controllers;

import case_study.furama.services.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main Menu\n" +
                    "1. Employee Management " +
                    "2. Customer Management " +
                    "3  Facility Management " +
                    "4. Booking Management " +
                    "5. Promotion Management " +
                    "6. Exit \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayEmployeeManagementMenu();
                    break;
                case "2":
                    displayCustomerManagementMenu();
                    break;
                case "3":
                    displayFacilityManagementMenu();
                    break;
                case "4":
                    displayBookingManagementMenu();
                    break;
                case "5":
                    displayPromotionManagementMenu();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void displayEmployeeManagementMenu() {
        System.out.println("Employee Management Menu\n" +
                "1 Display list employees " +
                "2 Add new employee " +
                "3 Edit employee " +
                "4 Return main menu\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                EmployeeServiceImpl.display();
                displayEmployeeManagementMenu();
                break;
            case "2":
                EmployeeServiceImpl.add();
                displayEmployeeManagementMenu();
                break;
            case "3":
                EmployeeServiceImpl.edit();
                displayEmployeeManagementMenu();
                break;
            case "4":
                break;
            default:
                System.out.println("Please enter again");
                displayEmployeeManagementMenu();
        }
    }

    static void displayCustomerManagementMenu() {
        System.out.println("Customer Management Menu\n" +
                "1 Display list customer " +
                "2 Add new customer " +
                "3 Edit customer " +
                "4 Return main menu\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                CustomerServiceImpl.display();
                displayCustomerManagementMenu();
                break;
            case "2":
                CustomerServiceImpl.add();
                displayCustomerManagementMenu();
                break;
            case "3":
                CustomerServiceImpl.edit();
                displayCustomerManagementMenu();
                break;
            case "4":
                break;
            default:
                System.out.println("Please enter again");
                displayCustomerManagementMenu();
        }
    }

    static void displayFacilityManagementMenu() {
        System.out.println("Facility Management Menu\n" +
                "1 Display list facility " +
                "2 Add new facility " +
                "3 Display list facility maintenance " +
                "4 Return main menu\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                FacilityServiceImpl.displayFacility();
                displayFacilityManagementMenu();
                break;
            case "2":
                FacilityServiceImpl.add();
                displayFacilityManagementMenu();
                break;
            case "3":
                FacilityServiceImpl.displayListFacilityMaintenance();
                displayFacilityManagementMenu();
                break;
            case "4":
                break;
            default:
                System.out.println("Please enter again");
                displayFacilityManagementMenu();
        }
    }

    static void displayBookingManagementMenu() {
        System.out.println("Booking Management Menu\n" +
                "1 Add new booking " +
                "2 Display list booking " +
                "3 Create new contracts " +
                "4 Display list contracts " +
                "5 Edit contracts " +
                "6 Return main menu\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                CustomerServiceImpl.display();
                FacilityServiceImpl.displayFacility();
                BookingServiceImpl.add();
                displayBookingManagementMenu();
                break;
            case "2":
                BookingServiceImpl.display();
                displayBookingManagementMenu();
                break;
            case "3":
                ContactServiceImpl.add();
                displayBookingManagementMenu();
                break;
            case "4":
                ContactServiceImpl.display();
                displayBookingManagementMenu();
                break;
            case "5":
                ContactServiceImpl.edit();
                displayBookingManagementMenu();
                break;
            case "6":
                break;
            default:
                System.out.println("Please enter again");
                displayBookingManagementMenu();
        }
    }

    static void displayPromotionManagementMenu() {
        System.out.println("Promotion Management Menu\n" +
                "1 Display list customers use service " +
                "2 Display list customers get voucher " +
                "3 Return main menu\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                PromotionServiceImpl.display();
                displayPromotionManagementMenu();
                break;
            case "2":
                PromotionServiceImpl.displayListCustomersGetVoucher();
                displayPromotionManagementMenu();
                break;
            case "3":
                break;
            default:
                System.out.println("Please enter again");
                displayPromotionManagementMenu();
        }
    }

}
