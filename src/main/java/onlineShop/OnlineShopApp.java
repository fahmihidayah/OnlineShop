package onlineShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Damian Bartos on 20.06.2016.
 */
@EnableAutoConfiguration
@ComponentScan({"controllers"})
@SpringBootApplication
public class OnlineShopApp {
    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApp.class, args);
    }
}
