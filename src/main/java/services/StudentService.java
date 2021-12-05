package services;

import data.StudentJDBCDAO;
import data.StudentORMDAO;
import entities.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

//    private StudentJDBCDAO studentJDBCDAO;
    private StudentORMDAO studentORMDAO;

    public StudentService() throws SQLException{

//        studentJDBCDAO = new StudentJDBCDAO();
        studentORMDAO = new StudentORMDAO();
    }

    public int save(Student student) throws SQLException {
//        return studentJDBCDAO.save(student);
        return studentORMDAO.save(student);
    }

    public List<Student> getAll() throws SQLException {
//        return studentJDBCDAO.getAll();
        return studentORMDAO.getAll();
    }

    public void delete(int id) throws SQLException {

//        studentJDBCDAO.delete(id);
        studentORMDAO.delete(id);
    }

    public void edit(Student student) throws SQLException {

//        studentJDBCDAO.edit(student);
        studentORMDAO.edit(student);
    }

    public Student findById(int id) throws SQLException {
//        return studentJDBCDAO.findById(id);
        return studentORMDAO.findById(id);
    }

    public Student findBySsn(String ssn) throws SQLException {
//        return studentJDBCDAO.findBySsn(ssn);
        return studentORMDAO.findBySsn(ssn);
    }
}
