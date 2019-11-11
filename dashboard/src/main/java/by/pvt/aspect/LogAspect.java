package by.pvt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;


@Component
@Aspect
public class LogAspect {

    private static final Logger log = Logger.getLogger("logAspect");

    private Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        StringBuilder info = new StringBuilder();
        long start = System.currentTimeMillis();
        Object result = jp.proceed();
        info.append(jp.getTarget().getClass().getSimpleName()).append(".")
                .append(jp.getSignature().getName())
                .append("(").append(Arrays.toString(jp.getArgs())).append(")")
                .append(" : ").append(result)
                .append(" in ").append(System.currentTimeMillis() - start).append(" msec.");
        log.info(info.toString());
        return result;
    }

    @Around("execution(* by.pvt.repository.*.*(..))")
    public Object logRepository(ProceedingJoinPoint jp) throws Throwable {
        return logMethodInvocation(jp);
    }

    @Around("execution(* by.pvt.service.*.*(..))")
    public Object logService(ProceedingJoinPoint jp) throws Throwable {
        return logMethodInvocation(jp);
    }
}
