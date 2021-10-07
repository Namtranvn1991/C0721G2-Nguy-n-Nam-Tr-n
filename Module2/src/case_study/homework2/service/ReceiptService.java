package case_study.homework2.service;

import case_study.homework2.model.Customer;
import case_study.homework2.model.Receipt;
import case_study.homework2.util.ReadReceiptListAndWriteToCSV;
import case_study.homework2.util.ReceiptInput;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ReceiptService {
    private static LinkedList<Receipt> receipts = ReadReceiptListAndWriteToCSV.getListFromCSV();
    static Scanner scanner = new Scanner(System.in);

    public static void add() {
        String id = "MHD-" + (receipts.size() + 1);
        System.out.println(id);
        //String receiptID = ReceiptInput.inputReceiptID();
        Customer customer = ReceiptInput.inputCustomer();
        Date receiptDate = ReceiptInput.inputDate();
        int quantity = ReceiptInput.inputQuantity();
        int unitPrice = ReceiptInput.inputUnitPrice();
        Receipt receipt = new Receipt(id, customer, receiptDate, quantity, unitPrice);
        System.out.println(receipt);
        receipts.add(receipt);
        ReadReceiptListAndWriteToCSV.writeToCSV(receipts);
    }

    public static void edit() {
        while (true) {
            display();
            System.out.println("Enter Receipt ID to edit");
            String receiptID = scanner.nextLine();
            if (validateReceiptID(receiptID)) {
                for (Receipt receipt : receipts) {
                    if (receipt.getReceiptID().equals(receiptID)) {
                        System.out.println(receipt);
                        editReceipt(receipt);
                        ReadReceiptListAndWriteToCSV.writeToCSV(receipts);
                        return;
                    }
                }
                System.out.println("Receipt ID doest exist");
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static void editReceipt(Receipt receipt) {
        System.out.println("Edit 1. Customer 2. ReceiptDate 3. Quantity 4.UnitPrice 5. Return");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                receipt.setCustomer(ReceiptInput.inputCustomer());
                break;
            case "2":
                receipt.setReceiptDate(ReceiptInput.inputDate());
                break;
            case "3":
                receipt.setQuantity(ReceiptInput.inputQuantity());
                break;
            case "4":
                receipt.setUnitPrice(ReceiptInput.inputUnitPrice());
                break;
            default:
                return;
        }
    }

    public static void display() {
        for (Receipt receipt : receipts) {
            System.out.println(receipt);
        }
    }

    public static void displayDetail() {
        for (Receipt receipt : receipts) {
            System.out.println(receipt.toStringDetail());
        }
    }

    public static boolean validateReceiptID(String receiptID) {
        String regex = "MHD-\\d{0,3}";
        return receiptID.matches(regex);
    }

}
