package model;

import java.util.Date;

public class Customer extends Person {
    private int id_customer;
    private int type_customer;

    final static String DIAMOND = "Diamond";
    final static String PLATINUM = "Platinum";
    final static String GOLD = "Gold";
    final static String SILVER = "Silver";
    final static String MEMBER = "Member";

    public Customer() {
    }

    public Customer(int id_customer, String name, Date birthday, String id_card, String phone_number, String address, String email, int type_customer) {
        super(name, birthday, id_card, phone_number, address, email);
        this.id_customer = id_customer;
        this.type_customer = type_customer;
    }

    public Customer(String name, Date birthday, String id_card, String phone_number, String address, String email, int type_customer) {
        super(name, birthday, id_card, phone_number, address, email);
        this.type_customer = type_customer;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getType_customer() {
        return type_customer;
    }

    public void setType_customer(int type_customer) {
        this.type_customer = type_customer;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "id_customer=" + id_customer +
                ", type_customer=" + type_customer +
                '}';
    }
}
