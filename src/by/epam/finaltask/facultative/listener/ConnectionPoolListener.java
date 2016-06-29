package by.epam.finaltask.facultative.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPoolListener implements ServletContextListener {
   private static final Logger LOGGER = LogManager.getRootLogger();
    private static ConnectionPool dbConnectionPool;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            dbConnectionPool = ConnectionPool.getInstance();
            dbConnectionPool.initPoolData();
            LOGGER.info("Connection pool initialized successfully");
        } catch (ConnectionPoolException e) {
            throw new ConnectionPoolNotInitializedException("Connection cannot be initialized", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

            dbConnectionPool.dispose();
            LOGGER.info("Connection pool destroyed successfully");

    }
}