package com.test.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

/**
 * Application Lifecycle Listener implementation class ContextFinalizer
 *
 */
@WebListener
public class ContextFinalizer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextFinalizer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    


	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


	
	
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            System.out.println("Servlet销毁");
            //SqlConnection.dbDestroyed();
            Enumeration drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = (Driver) drivers.nextElement();
                DriverManager.deregisterDriver(driver);
                System.out.println("deregistering jdbc driver: " + driver);
            }
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("销毁工作异常");
        }
 
    }

	
	
	
}
