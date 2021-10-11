package service;

import model.*;
import util.PassBookInput;
import util.ReadShortTermListAndWriteToCSV;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ShortTermPBService {
    static LinkedList<PassBook> shortTermList = ReadShortTermListAndWriteToCSV.getShortTermListFromCSV();
    static Scanner scanner = new Scanner(System.in);

    public static LinkedList<PassBook> getShortTermList() {
        return shortTermList;
    }

    public static void add(){
        String bookID = PassBookInput.bookIDShort();
        Customer customer = PassBookInput.inputCustomer();
        Date openDate = PassBookInput.inputOpenDay();
        Date beginDate = PassBookInput.inputBeginDay();
        int balance = PassBookInput.inputBalance();
        int interestRate = PassBookInput.inputInterestRate();
    }

    public static void addLimit(){
        String bookID = PassBookInput.bookIDShort();
        Customer customer = PassBookInput.inputCustomer();
        Date openDate = PassBookInput.inputOpenDay();
        Date beginDate = PassBookInput.inputBeginDay();
        int balance = PassBookInput.inputBalance();
        int interestRate = PassBookInput.inputInterestRate();
        String term = PassBookInput.inputShortTerm();
        ShortTermLimitPB shortTermLimitPB = new ShortTermLimitPB(bookID,customer,openDate,beginDate,balance,interestRate,term);
        shortTermList.add(shortTermLimitPB);
        ReadShortTermListAndWriteToCSV.writeToCSV(shortTermList);
    }

    public static void addNoLimit(){
        String bookID = PassBookInput.bookIDShort();
        Customer customer = PassBookInput.inputCustomer();
        Date openDate = PassBookInput.inputOpenDay();
        Date beginDate = PassBookInput.inputBeginDay();
        int balance = PassBookInput.inputBalance();
        int interestRate = PassBookInput.inputInterestRate();
        ShortTermNoLimitPB shortTermNoLimitPB = new ShortTermNoLimitPB(bookID,customer,openDate,beginDate,balance,interestRate);
        shortTermList.add(shortTermNoLimitPB);
        ReadShortTermListAndWriteToCSV.writeToCSV(shortTermList);
    }

    public static void display(){
        for (PassBook passBook: shortTermList) {
            System.out.println(passBook);
        }
    }

    public static void remove(){
        display();
        System.out.println("Enter bookID to remove");
        String bookId = scanner.nextLine();
        int index = -1;
        for (PassBook passBook:shortTermList) {
            if (bookId.equals(passBook.getBookID())){
                index = shortTermList.indexOf(passBook);
            }
        }
        if(index!=-1){
            System.out.println("Do y want to remove Y/N");
            String choice = scanner.nextLine();
            switch (choice){
                case "y":
                case "Y":
                    shortTermList.remove(index);
                    System.out.println("remove success");
                    ReadShortTermListAndWriteToCSV.writeToCSV(shortTermList);
                    return;
                default:
                    return;
            }
        } else {
            System.out.println("id doest exist");
        }

    }


}
