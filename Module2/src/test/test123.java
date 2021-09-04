package test;

public class test123 {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("name? " + student.name);
        System.out.println("age? " + student.age);
        System.out.println("isScienceMajor? " + student.isScienceMajor);
        System.out.println("gender? " + student.gender);
    }
}
class Student {
    String name; // name có giá trị mặc định là null
    int age; // age có giá trị mặc định là 0
    boolean isScienceMajor; // isScienceMajor có giá trị mặc định là false
    char gender; // gender có giá trị mặc định là '\u0000'
}