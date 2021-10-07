package model;

import java.util.Date;

public class Test implements Comparable<Test> {
    String name;
    Date date;
    int number;

    public Test()  {
    }

    public Test(String name, Date date, int number) {
        this.name = name;
        this.date = date;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", number=" + number +
                '}';
    }

    public String toStringToFile() {
        return name +
                "," + date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear()+1900) +
                "," + number;
    }

    @Override
    public int compareTo(Test o) {
        return 0;
    }
}
