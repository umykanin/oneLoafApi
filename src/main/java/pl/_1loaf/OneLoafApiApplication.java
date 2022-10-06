package pl._1loaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl._1loaf.security.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class OneLoafApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneLoafApiApplication.class, args);

    }
}
