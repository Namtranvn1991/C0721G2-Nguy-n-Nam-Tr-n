package model;

import java.util.Date;

public class ShortTermLimitPB extends PassBook {
    private String term;
    public static final String SIX_MONTH = "6 tháng";
    public static final String THREE_MONTH = "3 tháng";

    public ShortTermLimitPB() {
    }

    public ShortTermLimitPB(String bookID, Customer customer, Date openDay, Date beginDay, int balance, int interestRate, String term) {
        super(bookID, customer, openDay, beginDay, balance, interestRate);
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return super.toString() + "ShortTermLimitPB{" +
                "term='" + term + '\'' +
                '}';
    }

    @Override
    public String toStringToFile() {
        return "Limit," + super.toStringToFile() + "," + term;
    }

}
