package beam;

import java.util.Date;

public class Customer {
    private String name;
    private Date birthday;
    private String address;
    private String img;
    private String birthdayStr;

    public Customer() {
    }


    public Customer(String name, Date birthday, String address, String img) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.img = img;
        this.birthdayStr = getBirthdayToString();
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getBirthdayToString() {
        String dateStr = (birthday.getYear() + 1900) + "-" + (birthday.getMonth() + 1) + "-" + birthday.getDay();
        return dateStr;
    }
}
