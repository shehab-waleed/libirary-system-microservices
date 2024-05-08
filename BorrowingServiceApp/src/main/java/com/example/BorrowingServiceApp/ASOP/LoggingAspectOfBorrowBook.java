package com.example.BorrowingServiceApp.ASOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectOfBorrowBook {

    @Pointcut("execution(* com.example.BorrowingServiceApp.controller..*(..))")
    public void loggingPointCutBorrowBook(){}


    @Before("loggingPointCutBorrowBook()")
    public void beforeLoginMethods(JoinPoint joinPoint) {
        //Logger logger;
        log.info("Before executing book-api..."+joinPoint.getSignature().getName() );
    }

    @After("loggingPointCutBorrowBook()")
    public void afterLoginMethods(JoinPoint joinPoint)
    {
        log.info("After executing book-api..."+joinPoint.getSignature().getName() );
    }

}
