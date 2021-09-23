package test.ss16_io_text.model;
public class Student extends Person {
    private String subject;

    public Student() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student(String name, int age, String address, String subjetc) {
        super(name, age, address);
        this.subject =subjetc;
    }

    @Override
    public void goToBy() {
        System.out.println(" Bằng xe máy");
    }
    @Override
    public String toString() {
        return "Sinh viên{" +
                ", name='" + getName()+ '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress()+ '\'' +
                ", subject='" + getSubject() + '\'' +
                '}';
    }

//    String name, int age, String address, String subjetc
    public String getInfoToCSV(){
        return name+","+age+","+ address+","+ subject;
    }
}
