package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author gehejun
 */
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages =
        {"annotation", "aspect", "controller", "executor", "handler", "service"}
        )
public class ChickStarter {
    public static void main(String[] args) {
        SpringApplication.run(ChickStarter.class, args);
    }
}
