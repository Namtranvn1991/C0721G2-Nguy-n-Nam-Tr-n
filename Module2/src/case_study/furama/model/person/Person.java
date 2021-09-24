package case_study.furama.model.person;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {
    private String name;
    private Date birthday;
    private boolean gender;
    private int iDCardNumber;
    private int phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, Date birthday, Boolean gender, int iDCardNumber, int phoneNumber, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.iDCardNumber = iDCardNumber;
        this.phoneNumber = phoneNumber;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public int getIDCardNumber() {
        return iDCardNumber;
    }

    public void setIDCardNumber(int iDCardNumber) {
        this.iDCardNumber = iDCardNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return iDCardNumber == person.iDCardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDCardNumber);
    }

    @Override
    public String toString() {
        String genderStr = "";
        if (gender) {
            genderStr = "Male";
        } else {
            genderStr = "Female";
        }
        return "name='" + name + '\'' +
                ", birthday=" + birthday.getDate() + "/" + (birthday.getMonth()+1) + "/" + (birthday.getYear()+1900) +
                ", gender=" + genderStr +
                ", iDCardNumber=" + iDCardNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + ", ";
    }

    public String toStringToFile() {
        String genderStr = "";
        if (gender) {
            genderStr = "Male";
        } else {
            genderStr = "Female";
        }
        return  name + "," +
                birthday.getDate() + "/" + (birthday.getMonth()+1) + "/" + (birthday.getYear()+1900) + ","+
                genderStr +","+
                iDCardNumber + "," +
                phoneNumber + "," +
                email;
    }

    @Override
    public int compareTo(Person o) {
        return this.getIDCardNumber()-o.getIDCardNumber();
    }
}
