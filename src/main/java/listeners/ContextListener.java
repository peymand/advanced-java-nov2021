package listeners;

import entities.Student;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("data", new Student());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
