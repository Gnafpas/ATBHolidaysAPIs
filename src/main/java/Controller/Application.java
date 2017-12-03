package Controller;

import Helper.ProjectProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Created by George on 29/05/17.
 */




@SpringBootApplication
public class Application extends SpringBootServletInitializer {
//todo change mysql driver and configure mysql for connection pooling

    public static Logger errLogger;


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        /**
         * Set up logger.
         */
        errLogger = Logger.getLogger("Errors");
        FileHandler fh;
        try {
            for(Handler handler:errLogger.getHandlers()) {
                errLogger.removeHandler(handler);
            }
            // This block configure the logger with handler and formatter
            fh = new FileHandler(ProjectProperties.logspath+"Errors.log");
            errLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        errLogger.info("App started...");
        return application.sources(Application.class);
    }
}

