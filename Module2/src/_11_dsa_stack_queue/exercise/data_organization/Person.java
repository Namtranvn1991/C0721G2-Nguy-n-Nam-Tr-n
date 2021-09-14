package _11_dsa_stack_queue.exercise.data_organization;

import _5_access_modifier_static_method_static_property.practice.Student;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private boolean gender;
    private int age;

    public Person() {
    }

    public Person(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (getAge() >o.getAge()) return 1;
        else if (getAge() < o.getAge()) return -1;
        else return 1;
    }
}
