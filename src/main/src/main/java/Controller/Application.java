package Controller;

import Helper.CustomErrLogger;
import Helper.CustomInfoLogger;
import Helper.ProjectProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.instrumentalapp.*;


/**
 * Created by George on 29/05/17.
 */




@SpringBootApplication
public class Application extends SpringBootServletInitializer {
//todo change mysql driver and configure mysql for connection pooling

    public static CustomErrLogger errLogger;
    public static CustomInfoLogger userlogs;
    public static Agent agent;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        agent = new Agent(new AgentOptions().setApiKey("164825f1c19e59d34c3f32faeb88f66f").setEnabled(true));

        /**
         * Set up logger.
         */
        Logger log=Logger.getLogger("Errors");
        errLogger = new CustomErrLogger(log.getName(),log.getResourceBundleName());
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

        Logger log2=Logger.getLogger("Userlog");
        userlogs = new CustomInfoLogger(log2.getName(),log2.getResourceBundleName());
        FileHandler fh2;
        try {
            for(Handler handler:userlogs.getHandlers()) {
                userlogs.removeHandler(handler);
            }
            // This block configure the logger with handler and formatter
            fh2 = new FileHandler(ProjectProperties.logspath+"Userlog.log");
            userlogs.addHandler(fh2);
            SimpleFormatter formatter2 = new SimpleFormatter();
            fh2.setFormatter(formatter2);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        errLogger.info("App started...");
//        userlogs.info("App started...");
        return application.sources(Application.class);
    }
}

