package org.easytours.tpmodel.logging;

public class LoggerFactory {
    public static LoggerWrapper getLogger() {
        Log4JWrapper logger = new Log4JWrapper();
        logger.initialize();
        return logger;
    }
}
