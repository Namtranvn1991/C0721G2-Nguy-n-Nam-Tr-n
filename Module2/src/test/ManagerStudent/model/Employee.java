package test.ManagerStudent.model;

public abstract class Employee extends Person {
    double salary;

    public Employee() {
    }

    public Employee(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "salary=" + salary +
                '}';
    }
}
