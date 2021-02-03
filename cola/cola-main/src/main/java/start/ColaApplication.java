package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/8/20 13:09
 */
@SpringBootApplication(scanBasePackages = {"core", "controller","executor","flow","service"})
public class ColaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ColaApplication.class, args);
    }
}
