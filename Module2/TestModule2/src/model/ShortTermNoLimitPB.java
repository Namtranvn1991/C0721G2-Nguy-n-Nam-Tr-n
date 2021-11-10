package model;

import java.util.Date;

public class ShortTermNoLimitPB extends PassBook {
    public ShortTermNoLimitPB() {
    }

    public ShortTermNoLimitPB(String bookID, Customer customer, Date openDay, Date beginDay, int balance, int interestRate) {
        super(bookID, customer, openDay, beginDay, balance, interestRate);
    }

    @Override
    public String toString() {
        return super.toString() + "ShortTermNoLimitPB{}";
    }

    @Override
    public String toStringToFile() {
        return "NoLimit," + super.toStringToFile();
    }
}
