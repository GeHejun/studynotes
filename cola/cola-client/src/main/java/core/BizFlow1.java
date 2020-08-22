package core;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface BizFlow1 {
    String type() default "";

    int order() default 0;

    String desc() default "关于这段代码的描述";
}
