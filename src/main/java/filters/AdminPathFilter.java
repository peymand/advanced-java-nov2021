package filters;

import controllers.LoginController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin/*" , "/admin-area.do"})
public class AdminPathFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (session == null)
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
        else {
            LoginController.RoleAndName rn = (LoginController.RoleAndName) session.getAttribute("rn");
            if (rn == null)
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
            else {
                String role = rn.getRole();
                if (role != null && role.equalsIgnoreCase("admin"))
                    filterChain.doFilter(request, response);
                else
                    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
