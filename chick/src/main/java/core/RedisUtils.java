package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author gehejun
 */
public class RedisUtils {

    private static StringRedisTemplate stringRedisTemplate = SpringBeanUtil.getBean(StringRedisTemplate.class);


    public static void put(TransactionContext context) {
        stringRedisTemplate.opsForList().leftPush(String.valueOf(context.getCurrentThread().getId()), context.toString());
    }

    public static void get(Long threadId) {
        String context = stringRedisTemplate.opsForList().leftPop(String.valueOf(threadId));
    }
}
