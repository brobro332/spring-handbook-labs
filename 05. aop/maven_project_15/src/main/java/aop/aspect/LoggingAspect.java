package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(aop.aspect.annotation.ToLog)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("logging aspect: calling the intercepted method");
        Object returnedValue = proceedingJoinPoint.proceed();
        logger.info("logging aspect: method executed and returned " + returnedValue);

        return returnedValue;
    }
}
