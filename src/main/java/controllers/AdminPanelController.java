package controllers;

import org.apache.catalina.realm.GenericPrincipal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebServlet("/admin-area.do")
public class AdminPanelController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericPrincipal principal = (GenericPrincipal) req.getUserPrincipal();
        System.out.println(principal.getPassword());
        req.getRequestDispatcher("/WEB-INF/admin/panel.jsp").forward(req, resp);
    }
}
