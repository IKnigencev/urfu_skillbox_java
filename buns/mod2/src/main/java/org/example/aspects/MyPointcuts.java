package org.example.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(public * get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(public * add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(public * *(..))")
    public void methodsWithLoggingThrows(){}

    @Pointcut("execution(public * getBook(..))")
    public void getBookMethod(){}
}
