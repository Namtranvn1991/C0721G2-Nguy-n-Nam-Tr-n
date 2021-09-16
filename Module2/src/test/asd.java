package test;

import _10_dsa_list.exercise.implement_the_methods_of_arraylist.MyList;

import java.util.Queue;
import java.util.*;

public class asd {
    public static void main(String[] args) {
        Student stu1 = new Student(123, "a", 13);
        Student stu2 = new Student(123, "A", 13);
        Student stu3 = new Student(444, "B", 12);
        Set<Student> list = new TreeSet<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        System.out.println(list);
    }
}

class Student implements Comparable<Student> {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                "__" + hashCode() +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        System.out.println(this.name.compareTo(o.name));
        return this.name.compareTo(o.name);
    }
}

