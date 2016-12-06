package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import shop.setup.data.Data;

@SpringBootApplication(scanBasePackages = "shop")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Data data = ctx.getBean(Data.class);
        data.setUp();
    }

}
