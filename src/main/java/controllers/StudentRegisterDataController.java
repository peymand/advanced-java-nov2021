package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Book;
import entities.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        String bookText = req.getParameter("bookTextVar");
        ApplicationContext context = (ApplicationContext) req.getServletContext().getAttribute("context");

        ObjectMapper mapper = (ObjectMapper) context.getBean("objectMapper");

        Book book = mapper.readValue(bookText, Book.class);


        logger.info(String.format("[request parameters : %s=name , %s , %s , %s , %s -> " +
                "goes to persist in database as a student]",name,family,major,ssn, book));
        Student student = new Student(ssn,name,family,major,book);

        try {
            StudentService service = (StudentService) context.getBean("service");

            service.save(student);
            logger.debug("user with ip=" + req.getRemoteAddr() + " visiting student list page ");
            resp.sendRedirect("/student-list-page.do");

        } catch (SQLException e) {
            String msg = "some error";
            resp.sendRedirect(req.getContextPath() +  "/error.do?msg=" + msg);
            logger.error(String.format("error in persist student with message %s",e.getMessage()));
        }
    }
}
