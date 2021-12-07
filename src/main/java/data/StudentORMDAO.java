package data;

import entities.Student;
import exceptions.StudentNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public class StudentORMDAO implements StudentDAO{


    @Autowired
    SessionFactory sessionFactory;


    @Override
    public int save(Student student) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(student);
        session.close();
        return 0;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query from_student = session.createQuery("from Student");
        List<Student> res =  from_student.list();
        return res;
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.detach(new Student(id));
        session.close();
    }

    @Override
    public int edit(Student student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        session.close();
        return 0;
    }

    @Override
    public Student findById(int id) throws SQLException, StudentNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        session.get(Student.class , id);
        session.close();
        return null;
    }

    @Override
    public Student findBySsn(String ssn) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Student student = (Student) session
                .createQuery("from Student s where s.ssn = :ssn")
                .setParameter("ssn",ssn)
                .getSingleResult();
        return student;
    }
}
