package core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.Map;

public class BizBootstrap implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        Map<String, Object> flowBeans = applicationContext.getBeansWithAnnotation(BizFlow.class);
        flowBeans.forEach((k,v) -> {
            System.out.println(k + " => " +  v);
        });
    }
}
