package tech.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TechListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("TechListener context init");
        sce.getServletContext().setAttribute("userName", "이준희");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("TechListener context destroy");
    }
}
