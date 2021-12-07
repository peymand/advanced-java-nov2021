package listeners;

import config.HibernateConfig;
import entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("data", new Student());
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        sce.getServletContext().setAttribute("context",context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
