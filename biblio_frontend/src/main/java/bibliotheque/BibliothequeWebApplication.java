package bibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("bibliotheque")
public class BibliothequeWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibliothequeWebApplication.class, args);
    }
}
