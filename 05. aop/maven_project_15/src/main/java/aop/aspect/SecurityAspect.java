package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {
    private final Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(aop.aspect.annotation.ToLog)")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("security aspect: calling the intercepted method");
        Object returnedValue = proceedingJoinPoint.proceed();
        logger.info("security aspect: method executed and returned " + returnedValue);

        return returnedValue;
    }
}
