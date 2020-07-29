package com.example.login.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class CheckUserAspect {

    private Logger logger = Logger.getLogger(CheckUserAspect.class.getName());

    @Pointcut("@annotation(com.example.login.annotation.AdminOnly)")
    public void checkUser(){}

    @Pointcut("execution(public * com.example.login.CheckUserService.checkUserLogin())")
    public void checkUser2(){}

    @Pointcut("execution(public * com.example.login.CheckUserService.checkUserAlive())")
    public void checkUser3(){}

    @After("checkUser()")
    public void log(){
        logger.log(Level.INFO, "checkLogin");
    }

    @Before("checkUser2()")
    public void log2(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget());
        logger.log(Level.INFO, "log2");
    }

    @AfterThrowing(value = "checkUser2()", throwing = "e")
    public void throw1(Throwable e){
        System.out.println(e.getMessage());
        logger.log(Level.INFO, "throw1");
    }

    @Around(value = "checkUser3()")
    public void throw1(ProceedingJoinPoint e) throws Throwable{
        logger.log(Level.INFO, "前置");
        e.proceed();//执行了切入点方法
        logger.log(Level.INFO, "后置");
    }
}
