package aspect;


import annotation.Rollback;
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
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
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
