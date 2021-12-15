package controllers;

import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
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

@WebServlet("/student-edit.do")

public class StudentEditController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String major = req.getParameter("major");
        String ssn = req.getParameter("ssn");

        //TODO : to be fixed
        Student st = new Student(Integer.parseInt(id),ssn,name,family,major,null);

        try {
            ApplicationContext context = (ApplicationContext) req.getServletContext().getAttribute("context");
            StudentService service = (StudentService) context.getBean("service");
            service.edit(st);
            resp.sendRedirect("/student-list-page.do");
        }catch (SQLException e){
            resp.sendRedirect("/error.do");
        }

    }
}
