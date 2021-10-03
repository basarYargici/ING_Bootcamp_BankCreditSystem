package com.example.demo.aspects.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PerformanceLoggerAspect {

    private static final Logger logger =LoggerFactory.getLogger(PerformanceLoggerAspect.class);

    @Around("@annotation(com.example.demo.aspects.performance.PerformanceAspect)")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        logger.info("Metod başlatıldı",pjp.getSignature());
        Object output = pjp.proceed();
        logger.info("Metod bitirildi");
        long elapsedTime = System.nanoTime() - start;
        logger.info("Metot koşturulma süresi : ",elapsedTime);
        return output;
    }

}
