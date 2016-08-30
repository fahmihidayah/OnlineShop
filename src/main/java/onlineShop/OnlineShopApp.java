package onlineShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Damian Bartos
 * 20.06.2016.
 */
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan({"onlineShop"})
@SpringBootApplication
@EnableScheduling
public class OnlineShopApp {
    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApp.class, args);
    }
}
