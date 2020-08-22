package core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class BizBootstrap1 implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;

    private static Map<String, Object> flowBeans;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        flowBeans = applicationContext.getBeansWithAnnotation(BizFlow1.class);
        flowBeans.forEach((k,v) -> {
            System.out.println(k + " => " +  v.getClass().getName());
        });
    }

    public static Map<String, Object> getFlowBeans() {
        return flowBeans;
    }
}
