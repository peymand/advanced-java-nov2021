package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/init.do")
public class InitController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String role = req.getParameter("role");
        HttpSession session = req.getSession();
        RoleAndName roleAndName = new RoleAndName(name, role);
        session.setAttribute("rn",roleAndName);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }
    public static class RoleAndName{
        private String name;
        private String role;

        public RoleAndName(String name, String role) {
            this.name = name;
            this.role = role;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.role;
        }
    }
}
