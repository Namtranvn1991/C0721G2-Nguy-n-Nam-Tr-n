package repository.impl;

import beam.Student;

import java.util.List;

public interface IStudentRepository {



    public Student selectStudent(int id_student);

    public List<Student> selectAllStudents();

}
