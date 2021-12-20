package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login.do"} , loadOnStartup = 1)
public class LoginController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String role = req.getParameter("role");
        HttpSession session = req.getSession();
        RoleAndName roleAndName = new RoleAndName(name, role);
        session.setAttribute("rn",roleAndName);
        if(role.equalsIgnoreCase("admin"))
            resp.sendRedirect("/admin-area.do");
        else
            resp.sendRedirect("/error.do");
    }
    public static class RoleAndName{
        private String name;
        private String role;

        public String getRole() {
            return role;
        }

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
