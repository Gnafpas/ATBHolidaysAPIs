package Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by George on 29/05/17.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /**
     *
     * Project Properties variables.
     */
    public static String apiKey="3491840412405367";
    public static String apiURL="http://prelive.viatorapi.viator.com";


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

