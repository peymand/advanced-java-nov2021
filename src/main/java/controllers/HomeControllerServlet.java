package controllers;

import entities.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/home.do" , "/index.jsp"})

public class HomeControllerServlet extends HttpServlet {


    private static final Logger logger = LogManager.getLogger(HomeControllerServlet.class);

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        Student student = (Student) context.getAttribute("data");
        logger.debug("in home controller");
        logger.info("Hello world");
        logger.warn("we are in logger info mode");
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
}
