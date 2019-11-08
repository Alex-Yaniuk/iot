package by.pvt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
@Aspect
public class LogAspect {

    private static final Logger log = Logger.getLogger("logAspect");

    @Before("execution(public * by.pvt.service.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint jp) {
        log.info("Invocation of method " + jp.getSignature());
    }
}
