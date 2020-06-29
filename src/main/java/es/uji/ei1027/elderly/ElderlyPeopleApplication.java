package es.uji.ei1027.elderly;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.logging.Logger;

@SpringBootApplication
public class ElderlyPeopleApplication{

    private static final Logger log = Logger.getLogger(ElderlyPeopleApplication.class.getName());

    public static void main(String[] args) {
        // Auto-configura l'aplicació
        new SpringApplicationBuilder(ElderlyPeopleApplication.class).run(args);
    }
}

