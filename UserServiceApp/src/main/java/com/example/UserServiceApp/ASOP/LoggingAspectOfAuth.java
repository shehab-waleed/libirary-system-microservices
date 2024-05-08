package com.example.UserServiceApp.ASOP;


import com.example.UserServiceApp.models.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Slf4j
public class LoggingAspectOfAuth {

    @Pointcut("execution(* com.example.UserServiceApp.login.controller..*(..))")
    public void loggingPointCutLogin(){}

    @Pointcut("execution(* com.example.UserServiceApp.register.controller..*(..))")
    public void loggingPointCutRegister(){}


    @Before("loggingPointCutLogin()")
    public void beforeLoginMethods(JoinPoint joinPoint) {
        //Logger logger;
        log.info("Before executing login-api..."+joinPoint.getSignature());
    }

    @After("loggingPointCutLogin()")
    public void afterLoginMethods(JoinPoint joinPoint)
    {
        log.info("After executing login-api..."+joinPoint.getSignature());
    }

    @AfterReturning(
            value = "execution(* com.example.UserServiceApp.login.controller..*(..))",
            returning = "responseEntity"
    )
    public void afterLogin(JoinPoint joinPoint, ResponseEntity<?> responseEntity) {
        if (responseEntity != null && responseEntity.getBody() != null) {
            Object body = responseEntity.getBody();
            if (body instanceof User) {
                User user = (User) body;
                log.info("Returned user: {}", user);
            }
        }
    }
    @Before("loggingPointCutRegister()")
    public void beforeRegisterMethods(JoinPoint joinPoint) {

        log.info("Before executing register-api..."+joinPoint.getSignature());
    }

    @After("loggingPointCutRegister()")
    public void afterRegisterMethods(JoinPoint joinPoint)
    {
        log.info("After executing register-api..."+joinPoint.getSignature());
    }



}
