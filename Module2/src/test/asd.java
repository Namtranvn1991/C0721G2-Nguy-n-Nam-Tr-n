package test;

import _10_dsa_list.exercise.implement_the_methods_of_arraylist.MyList;
import java.util.Queue;
import java.util.*;

public class asd {
    public static void main(String[] args) {
        Student stu1 = new Student(123, "qqq", 12);
        Student stu2 = new Student(123, "qqqq", 12);
        Student stu3 = new Student(444, "qqq", 12);
        Set<Student> list = new HashSet<>();
        Queue<Student> q = new ArrayDeque<>();
    }
}

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

