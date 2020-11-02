package starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.*;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/28 11:04
 */
@Data
@ConfigurationProperties(prefix = "threadpool")
public class ThreadPoolProperties {

    public Integer corePoolSize;

    public Long freeTime = 60L;

    public TimeUnit timeUnit = TimeUnit.SECONDS;

    public Integer maxPoolSize = Runtime.getRuntime().availableProcessors() + 1;

    public String rejectStrategy;

    public BlockingQueue blockingQueue = new ArrayBlockingQueue(100);

    public ThreadFactory threadFactory =  Executors.defaultThreadFactory();
}
