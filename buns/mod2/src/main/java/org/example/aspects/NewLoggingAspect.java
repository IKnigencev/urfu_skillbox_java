package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class NewLoggingAspect {

    @Before("org.example.aspects.MyPointcuts.getBookMethod()")
    public void beforeGetAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("beforeGetAdvice: вызов метода на get");
        System.out.println("Имя метода: " + methodSignature.getName());
        System.out.println("Параметры метода: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Возвращаемый тип данных метода: " + methodSignature.getReturnType());
        System.out.println("----------------------------");
    }

    @Before("org.example.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("beforeAddAdvice: вызов метода на add");
        System.out.println("Имя метода: " + methodSignature.getName());
        System.out.println("Параметры метода: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Возвращаемый тип данных метода: " + methodSignature.getReturnType());
        System.out.println("----------------------------");
    }

    @Around("org.example.aspects.MyPointcuts.methodsWithLoggingThrows()")
    public Object aroundLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
        throws Throwable {
        System.out.println("aroundLoggingAdvice: вызов метода");
        System.out.println("----------------------------");

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            System.out.println("aroundLoggingAdvice: было поймано исключение " + e);
            System.out.println("----------------------------");
            throw e;
        }

        System.out.println("aroundLoggingAdvice: успешно отработал метод");
        System.out.println("----------------------------");
        return targetMethodResult;
    }
}
