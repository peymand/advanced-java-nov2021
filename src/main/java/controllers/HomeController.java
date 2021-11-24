package controllers;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("in home controller");
        logger.info("Hello world");
        logger.warn("we are in logger info mode");
//        HttpSession session =  req.getSession();
//        InitController.RoleAndName  roleAndName= (InitController.RoleAndName) session.getAttribute("rn");
//        if(roleAndName !=null)
//            req.setAttribute("info", roleAndName);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
}
