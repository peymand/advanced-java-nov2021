package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Student;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class StudentFindBySsnController extends HttpServlet {

    int x;
    public StudentFindBySsnController(){
        x=10;
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data =  this.getServletConfig().getInitParameter("data");
        String ssn =  req.getParameter("ssn");
        try {
            StudentService service = new StudentService();
            Student student =  service.findBySsn(ssn);
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(student);
            resp.getWriter().print(result);

        } catch (SQLException e) {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(e.getMessage());
            resp.setStatus(500);
            resp.getWriter().print(result);
        }
    }
}
