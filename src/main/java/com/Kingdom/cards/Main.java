package com.Kingdom.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        //Change the "<RollingFile name="rollingfile" fileName="D:\Log4JLogs\smtrace.log"" Line tso the location
        //where you want to save your logs
        System.setProperty("log4j.configurationFile", "log4j2-test");
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined To Be :: " + System.getProperty("log4j.configurationFile"));
        System.out.print("Hello, world");
    }
}
//test commit  22