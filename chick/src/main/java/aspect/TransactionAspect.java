package aspect;


import annotation.Rollback;
import core.RedisUtils;
import core.TransactionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author gehejun
 */

@Aspect
@Component
public class TransactionAspect {

    @Around("@annotation(annotation.ThriftMethod)")
    public Object thriftMethod(ProceedingJoinPoint joinPoint) {
        TransactionContext context = new TransactionContext();
        Object result = null;
        try {
            context.setParams(joinPoint.getArgs());
            result = joinPoint.proceed();
            RedisUtils.put(context);
        } catch (Throwable throwable) {

        }
        return result;
    }

    @Around("@annotation(annotation.Rollback) && @annotation(rollback)")
    public Object rollback(ProceedingJoinPoint joinPoint, Rollback rollback) {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {

        }
        return result;
    }

    @Around("@annotation(annotation.Retry)")
    public Object retry(ProceedingJoinPoint joinPoint) {
        return null;
    }

}
