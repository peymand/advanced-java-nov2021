package data;

import entities.Student;
import exceptions.StudentNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class StudentORMDAO implements StudentDAO{



    @Override
    public int save(Student student) throws SQLException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return 0;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        Query from_student = session.createQuery("from Student");
        List<Student> res =  from_student.list();
        return res;
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.detach(new Student(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int edit(Student student) throws SQLException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.update(student);
        session.getTransaction().commit();
        session.close();
        return 0;
    }

    @Override
    public Student findById(int id) throws SQLException, StudentNotFoundException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.get(Student.class , id);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public Student findBySsn(String ssn) throws SQLException {
        Session session = ORMConfig.getSessionFactory().getCurrentSession();
        Student student = (Student) session
                .createQuery("from Student s where s.ssn = :ssn")
                .setParameter("ssn",ssn)
                .getSingleResult();
        return student;
    }
}
