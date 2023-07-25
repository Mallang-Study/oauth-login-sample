package mallang.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CeluveatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeluveatApplication.class, args);
    }

}
