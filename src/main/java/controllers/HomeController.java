package controllers;

import entities.Student;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home.do")

public class HomeController extends HttpServlet {


    private static final Logger logger = LogManager.getLogger(HomeController.class);

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
