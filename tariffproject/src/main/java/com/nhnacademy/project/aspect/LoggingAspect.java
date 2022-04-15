package com.nhnacademy.project.aspect;

import com.nhnacademy.project.config.Mainconfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    private static Log log = LogFactory.getLog(Mainconfig.class);

    @Around("within(com.nhnacademy.project..*)")
    public Object loggingSendMessage(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = getMethodName(pjp.toShortString());

        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info(methodName + ": ");
            log.info(stopWatch.getTotalTimeNanos() + " ns");
        }
    }

    String getMethodName(String initName) {
        String result = initName.replace("execution(", "");
        return result.substring(0, result.length()-1);
    }
}
