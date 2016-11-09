package com.example.di;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GreeterServletContextListener implements ServletContextListener {
    @Override public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
        servletContextEvent.getServletContext().setAttribute("appcomponent", applicationComponent);
    }

    @Override public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
