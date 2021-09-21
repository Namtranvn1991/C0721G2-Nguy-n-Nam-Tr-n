package case_study.furama.model.person;

import java.util.Date;

public class Customer extends Person {
    private int customerID;
    private String membershipTier;
    private String address;

    public static final String DIAMOND = "Diamond";
    public static final String PLATINUM = "Platinum";
    public static final String GOLD = "Gold";
    public  static final String SILVER = "Silver";
    public static final String MEMBER = "Member";

    public Customer() {
    }

    public Customer(String name, Date birthday, Boolean gender, int iDCardNumber, int phoneNumber, String email, int customerID, String membershipTier, String address) {
        super(name, birthday, gender, iDCardNumber, phoneNumber, email);
        this.customerID = customerID;
        this.membershipTier = membershipTier;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "customerID=" + customerID +
                ", membershipTier='" + membershipTier + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
