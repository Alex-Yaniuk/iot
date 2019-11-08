package by.pvt.aspect;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Log4j2
public class LogAspect {

    @Before("execution(public * by.pvt.service.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint jp) {
        log.log(Level.INFO, "Invocation of method " + jp.getSignature());
    }
}
