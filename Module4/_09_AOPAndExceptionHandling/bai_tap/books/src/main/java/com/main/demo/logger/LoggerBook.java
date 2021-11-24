package com.main.demo.logger;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerBook {

    @AfterReturning("execution(public * com.main.demo.service.BookService.*(..))")
    public void logBookService(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("phuong thuc " + className + " " + methodName);
    }

    @AfterThrowing(value = "execution(public * com.main.demo.service.BookService.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Exception " + className + " " + methodName + " " + exception.getMessage());
    }
}
