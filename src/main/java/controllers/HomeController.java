package controllers;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {


    private static final Logger logger = LogManager.getLogger(HomeController.class);



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BasicConfigurator.configure();
        logger.info("Hello world");
        logger.info("we are in logger info mode");

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
}
