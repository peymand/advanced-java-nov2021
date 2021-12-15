package controllers;

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

@WebServlet("/student-fetch-to-edit-page.do")

public class StudentFetchToEditController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        try{
            ApplicationContext context = (ApplicationContext) req.getServletContext().getAttribute("context");
            StudentService service = (StudentService) context.getBean("service");
            Student student =  service.findById(id);
            req.setAttribute("std", student);
            req.getRequestDispatcher("/WEB-INF/student-edit.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            resp.sendRedirect("/error.do");
        }
    }
}
