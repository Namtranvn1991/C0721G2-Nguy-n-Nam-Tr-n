package model;

import java.util.Date;

public abstract class Person {
    private String name;
    private Date birthday;
    private String id_card;
    private String phone_number;
    private String address;
    private String email;

    public Person() {
    }

    public Person(String name, Date birthday, String id_card, String phone_number, String address, String email) {
        this.name = name;

        this.birthday = birthday;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
