package _5_access_modifier_static_method_static_property.practice;

public class TestStaticMethod {
    public static void main(String[] args) {

        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");
        s1.display();
        s2.display();
        s3.display();
        Student.change();
        s1.display();
        s2.display();
        s3.display();

    }
}



