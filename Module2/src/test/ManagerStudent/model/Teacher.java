package test.ManagerStudent.model;

public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(String name, int age, String address, double salary) {
        super(name, age, address, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "salary=" + salary +
                '}';
    }
}
