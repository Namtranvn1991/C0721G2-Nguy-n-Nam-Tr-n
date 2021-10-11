package model;

import java.util.Date;

public class LongTermPB extends PassBook {
    private String term;
    private String goodwill;
    public static final String ONE_YEAR = "1 năm";
    public static final String THREE_YEAR = "3 năm";
    public static final String FIVE_YEAR = "5 năm";
    public static final String TEN_YEAR = "10 năm";


    public LongTermPB() {
    }

    public LongTermPB(String bookID, Customer customer, Date openDay, Date beginDay, int balance, int interestRate, String term, String goodwill) {
        super(bookID, customer, openDay, beginDay, balance, interestRate);
        this.term = term;
        this.goodwill = goodwill;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getGoodwill() {
        return goodwill;
    }

    public void setGoodwill(String goodwill) {
        this.goodwill = goodwill;
    }

    @Override
    public String toString() {
        return super.toString() + "LongTermPB{" +
                "term='" + term + '\'' +
                ", goodwill='" + goodwill + '\'' +
                '}';
    }

    public String toStringToFile() {
        return super.toStringToFile() +
                "," + term +
                "," + goodwill;
    }



}
