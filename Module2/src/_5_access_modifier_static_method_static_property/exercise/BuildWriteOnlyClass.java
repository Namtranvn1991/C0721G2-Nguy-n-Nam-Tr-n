package _5_access_modifier_static_method_static_property.exercise;

public class BuildWriteOnlyClass {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Tran");
        student.setName("Nam");

    }
}
class Student{
    private String name;
    private String classes;

    void setName(String name) {
        System.out.println("old:" + this.name);
        this.name = name;
        System.out.println(this.name);
    }

    public void setClasses(String classes) {
        System.out.println("old:" + this.classes);
        this.classes = classes;
        System.out.println(this.classes);
    }
}
