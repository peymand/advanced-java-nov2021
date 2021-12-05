package data;

import entities.Student;
import exceptions.StudentNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {

    int save(Student student) throws SQLException;

    List<Student> getAll() throws SQLException;

    void delete(int id) throws SQLException;

    int edit(Student student) throws SQLException;

    Student findById(int id) throws SQLException, StudentNotFoundException;

    Student findBySsn(String ssn) throws SQLException;

}
