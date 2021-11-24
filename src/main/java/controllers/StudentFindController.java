package controllers;

import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student-find-page.do")
public class StudentFindController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String value = WebUtil.getCookieValue("init-name", cookies);
        req.setAttribute("name", value);
        req.getRequestDispatcher("/WEB-INF/student-find.jsp").forward(req, resp);
    }

}
