package test.ss16_io_text.model;

public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(double salary) {
        super(salary);
    }

    public Teacher(String name, int age, String address, double salary) {
        super(name, age, address, salary);
    }
    public void teach(String subject){
        System.out.println(subject);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", salary='" +getSalary()+ '\'' +
                '}';
    }

    @Override
    public void goToBy() {
        System.out.println("di chuyển bằng oto");
    }

}
