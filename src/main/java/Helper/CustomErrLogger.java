package Helper;

import Controller.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by George on 13/04/2018.
 */
public class CustomErrLogger extends Logger {


    public CustomErrLogger(String name, String resourceBundleName) {
        super(name,resourceBundleName);
    }

    public void info(String msg) {
        Application.agent.increment("app.web.error.generalError");
        Application.agent.notice(msg);
        log(Level.INFO, msg);
    }
}
