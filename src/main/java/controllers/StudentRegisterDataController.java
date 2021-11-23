package controllers;

import entities.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/student-register.do")
public class StudentRegisterDataController extends HttpServlet {

    private static Logger logger = LogManager.getLogger(StudentRegisterDataController.class);

    public StudentRegisterDataController(){

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String major = req.getParameter("major");
        String ssn = req.getParameter("ssn");



        logger.info(String.format("[request parameters : %s=name , %s , %s , %s -> " +
                "goes to persist in database as a student]",name,family,major,ssn));
        Student student = new Student(ssn,name,family,major);

        try {
            StudentService studentService = new StudentService();
            studentService.save(student);
            logger.debug("user with ip=" + req.getRemoteAddr() + " visiting student list page ");
            resp.sendRedirect("/student-list-page.do");

        } catch (SQLException e) {
            String msg = "some error";
            resp.sendRedirect("/error.do?msg=" + msg);
            logger.error(String.format("error in persist student with message %s",e.getMessage()));
        }
    }
}
