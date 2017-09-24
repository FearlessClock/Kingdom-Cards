import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApp {

    public static void main( String[] args ) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\piete\\IdeaProjects\\tdspLog4J\\src\\main\\resources\\log4j2-test");
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined To Be :: "+System.getProperty("log4j.configurationFile"));
    }
}
