package core;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface BizFlow1 {
    String type() default "";

    String desc() default "关于这段代码的描述";
}
