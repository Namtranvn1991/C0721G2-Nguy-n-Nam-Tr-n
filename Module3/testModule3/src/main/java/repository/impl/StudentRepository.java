package repository.impl;

import beam.BaseRepository;
import beam.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM test_module_3.student where id_student = ?;";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM test_module_3.student;";

    @Override
    public Student selectStudent(int id_student) {
        Student student = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1,id_student);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_student");
                String name_student = resultSet.getString("name_student");
                String name_class = resultSet.getString("name_class");
                student = new Student(id_student,name_student,name_class);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_student = resultSet.getInt("id_student");
                String name_student = resultSet.getString("name_student");
                String name_class = resultSet.getString("name_class");
                Student student = new Student(id_student,name_student,name_class);
                studentList.add(student);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        List<Student> studentList = studentRepository.selectAllStudents();
        for (Student student:studentList) {
            System.out.println(student);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
