package test.ss16_io_text.model;

import java.util.Objects;

public abstract class Person{
    String name;
    int age;
    String address;
    public Person() {
    }
    public Person(String name) {
        this.name=name;
    }
    public Person(String name, int age, String address1) {
        this.name = name;
        this.age = age;
        this.address = address1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public abstract void goToBy();
    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
