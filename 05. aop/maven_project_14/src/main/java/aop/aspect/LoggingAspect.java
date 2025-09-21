package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // @Around("@annotation(aop.aspect.annotation.ToLog)")
    @AfterReturning(
        value = "@annotation(aop.aspect.annotation.ToLog)",
        returning = "returnedValue"
    )
    public void log(Object returnedValue) throws Throwable {
        /*
            String methodName = proceedingJoinPoint.getSignature().getName();
            Object[] arguments = proceedingJoinPoint.getArgs();

            logger.info("method: " + methodName + " with parameters: " + Arrays.asList(arguments) + " will execute");
            proceedingJoinPoint.proceed();
        */

        logger.info("method executed and returned " + returnedValue);
    }
}
