package _11_dsa_stack_queue.exercise.data_organization;

import _5_access_modifier_static_method_static_property.practice.Student;

import java.lang.reflect.Array;
import java.util.*;

public class List {
    static ArrayList<Person> list = new ArrayList<>();

    static {
        list.add(new Person("A", true, 23));
        list.add(new Person("B", true, 43));
        list.add(new Person("C", false, 44));
        list.add(new Person("D", true, 22));
        list.add(new Person("E", true, 55));
        list.add(new Person("F", false, 42));
        list.add(new Person("G", true, 77));
        list.add(new Person("H", false, 23));
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p);
        }
        System.out.println("_________________");
        Queue<Person> male = new ArrayDeque<>();
        Queue<Person> female = new ArrayDeque<>();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).isGender()){
                male.add(list.get(i));
            } else {
                female.add(list.get(i));
            }
        }
        list.clear();
        while (!male.isEmpty()){
            list.add(male.remove());
        }
        while (!female.isEmpty()){
            list.add(female.remove());
        }
        for (Person p : list) {
            System.out.println(p);
        }
    }
}
