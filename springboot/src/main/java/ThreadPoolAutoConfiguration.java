import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/28 11:07
 */
@Configuration
@ConditionalOnClass(ThreadPoolExecutor.class)
@EnableConfigurationProperties(ThreadPoolProperties.class)
public class ThreadPoolAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor threadPoolResolver(ThreadPoolProperties threadPoolProperties) {
        Integer corePoolSize = threadPoolProperties.getCorePoolSize();
        Integer maxPoolSize = threadPoolProperties.getMaxPoolSize();
        Long freeTime = threadPoolProperties.getFreeTime();
        TimeUnit timeUnit = threadPoolProperties.getTimeUnit();
        BlockingQueue blockingQueue = threadPoolProperties.getBlockingQueue();
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, freeTime, timeUnit, blockingQueue);
    }

}
