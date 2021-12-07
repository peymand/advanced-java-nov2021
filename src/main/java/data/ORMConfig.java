package data;

import entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMConfig {

    private static SessionFactory sessionFactory;

    static {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
            addAnnotatedClass(Student.class).buildSessionFactory();
    }

    private ORMConfig(){

    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory!=null)
            return sessionFactory;
        else
            return new Configuration().
                    addAnnotatedClass(Student.class).buildSessionFactory();
    }

}
