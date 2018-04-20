package Helper;

import Controller.Application;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by George on 13/04/2018.
 */
public class CustomInfoLogger extends Logger {


    public CustomInfoLogger(String name, String resourceBundleName) {
        super(name,resourceBundleName);
    }

    public void info(String msg) {
        Application.agent.increment("app.web.webSite.hotelUsers");
        log(Level.INFO, msg);
    }
}

