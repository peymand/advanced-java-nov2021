package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Student;
import org.springframework.context.ApplicationContext;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class StudentFindBySsnController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ssn =  req.getParameter("ssn");
        try {
            ApplicationContext context = (ApplicationContext) req.getServletContext().getAttribute("context");
            StudentService service = (StudentService) context.getBean("service");
            Student student =  service.findBySsn(ssn);
            ObjectMapper mapper = new ObjectMapper();
            if(student == null){
                resp.getWriter().print(mapper.writeValueAsString("OK"));
            }else{
                student.getBook().setStudent(null);
                String result = mapper.writeValueAsString(student);
                resp.getWriter().print(result);
            }


        } catch (SQLException e) {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(e.getMessage());
            resp.setStatus(500);
            resp.getWriter().print(result);
        }
    }
}
