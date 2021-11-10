package beam;

public class Student {
    private int id_student;
    private String name_student;
    private String name_class;

    public Student() {
    }

    public Student(int id_student, String name_student, String name_class) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.name_class = name_class;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", name_student='" + name_student + '\'' +
                ", name_class='" + name_class + '\'' +
                '}';
    }
}
