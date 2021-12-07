package services;

import data.StudentJDBCDAO;
import data.StudentORMDAO;
import entities.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;

@Service("service")
@Scope("singleton")
public class StudentService {

    @Autowired
    Logger logger;

    @Value("10")
    private int item;
//    private StudentJDBCDAO studentJDBCDAO;
    @Autowired
    private StudentORMDAO studentORMDAO;

    public StudentService() throws SQLException{

//        studentJDBCDAO = new StudentJDBCDAO();
//        studentORMDAO = new StudentORMDAO();
    }
    @PostConstruct
    public void f(){
        logger.info("this is in service object");
    }
    @Transactional
    public int save(Student student) throws SQLException {
//        return studentJDBCDAO.save(student);
        return studentORMDAO.save(student);
    }
    @Transactional
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
