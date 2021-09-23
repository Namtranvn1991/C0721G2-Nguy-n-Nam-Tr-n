package test.ss16_io_text.model;



public class Employee extends Person {
    double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }
    @Override
    public void goToBy() {
        System.out.println("di chuyển bằng xem máy hoặc oto");
    }
    public void work(String work){

    }
    @Override
    public String toString() {
        return "{" +
                "salary=" + salary +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", salary='" +getSalary() + '\'' +
                '}';
    }
}
