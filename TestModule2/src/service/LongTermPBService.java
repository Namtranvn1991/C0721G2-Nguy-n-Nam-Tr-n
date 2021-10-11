package service;

import model.Customer;
import model.LongTermPB;
import model.PassBook;
import util.PassBookInput;
import util.ReadLongTermListAndWriteToCSV;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class LongTermPBService {
    static Scanner scanner = new Scanner(System.in);
    public static LinkedList<LongTermPB> longTermPBList = ReadLongTermListAndWriteToCSV.getLongTermListFromCSV();

    public static void add(){
        String bookID = PassBookInput.bookID();
        Customer customer = PassBookInput.inputCustomer();
        Date openDate = PassBookInput.inputOpenDay();
        Date beginDate = PassBookInput.inputBeginDay();
        int balance = PassBookInput.inputBalance();
        int interestRate = PassBookInput.inputInterestRate();
        String term = PassBookInput.inputTerm();
        String goodwill = PassBookInput.inputGoodwill();
        LongTermPB longTermPB = new LongTermPB(bookID,customer,openDate,beginDate,balance,interestRate,term,goodwill);
        longTermPBList.add(longTermPB);
        ReadLongTermListAndWriteToCSV.writeToCSV(longTermPBList);
    }

    public static void display(){
        for (LongTermPB longTermPB:longTermPBList) {
            System.out.println(longTermPB);
        }
    }

    public static void remove(){
        display();
        System.out.println("Enter bookID to remove");
        String bookId = scanner.nextLine();
        int index = -1;
        for (LongTermPB longTermPB:longTermPBList) {
            if (bookId.equals(longTermPB.getBookID())){
                index = longTermPBList.indexOf(longTermPB);
            }
        }
        if(index!=-1){
            System.out.println("Do y want to remove Y/N");
            String choice = scanner.nextLine();
            switch (choice){
                case "y":
                case "Y":
                    longTermPBList.remove(index);
                    System.out.println("remove success");
                    ReadLongTermListAndWriteToCSV.writeToCSV(longTermPBList);
                    return;
                default:
                    return;
            }
        } else {
            System.out.println("id doest exist");
        }
    }
}
