package model;

import java.util.Date;

public abstract class PassBook {
    private String bookID;
    private Customer customer;
    private Date openDay;
    private Date beginDay;
    private int balance;
    private int interestRate;

    public PassBook() {
    }

    public PassBook(String bookID, Customer customer, Date openDay, Date beginDay, int balance, int interestRate) {
        this.bookID = bookID;
        this.customer = customer;
        this.openDay = openDay;
        this.beginDay = beginDay;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOpenDay() {
        return openDay;
    }

    public void setOpenDay(Date openDay) {
        this.openDay = openDay;
    }

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "PassBook{" +
                "bookID='" + bookID + '\'' +
                ", customer=" + customer +
                ", openDay=" + openDay.getDate() + "/" + (openDay.getMonth()+1) + "/" + (openDay.getYear()+1900) +
                ", beginDay=" + beginDay.getDate() + "/" + (beginDay.getMonth()+1) + "/" + (beginDay.getYear()+1900) +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }

    public String toStringToFile() {
        return bookID +
                "," + customer.getId() +
                "," + openDay.getDate() + "/" + (openDay.getMonth()+1) + "/" + (openDay.getYear()+1900) +
                "," + beginDay.getDate() + "/" + (beginDay.getMonth()+1) + "/" + (beginDay.getYear()+1900) +
                "," + balance +
                "," + interestRate;
    }
}
