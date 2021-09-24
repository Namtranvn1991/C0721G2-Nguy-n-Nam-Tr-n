package _17_io_binary_file_and_serialization.practice.readAndWriteStudentList;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;

    private String name;

    private String address;

    private Car car;

    public Student() {
    }

    public Student(int id, String name, String address, Car car) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                '}';
    }
}