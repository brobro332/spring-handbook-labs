package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    /*
     * [관점 지향 프로그래밍]
     * 1. 구성 클래스에 @EnableAspectJAutoProxy 애노테이션을 지정해야 한다.
     * 2. @Aspect를 지정한다고 빈이 생성되는 것은 아니다.
     * 3. @Around 애노테이션은 어떤 메서드를 가로챌지 정의한다.
     * 4. ProceedingJoinPoint 인스턴스의 proceed() 메서드를 통해 실제 메서드를 처리한다.
     */
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* aop.service.*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();

        logger.info("method: " + methodName + " with parameters: " + Arrays.asList(arguments) + " will execute");
        Object returnedByMethod = proceedingJoinPoint.proceed();

        logger.info("method executed and return: " + returnedByMethod);

        return returnedByMethod + " is returned by aspect";
    }
}
