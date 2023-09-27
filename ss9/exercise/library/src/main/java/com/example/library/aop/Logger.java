package com.example.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

public class Logger {
    public static int count = 0;
    @After("execution(* com.example.book_rent.controller.BookController.*(..))")
    public void count() {
        count++;
        System.out.println("Number Traffic is " + count);
    }
    @After("execution(* com.example.book_rent.controller.BookController.*(..))")
    public void writeLog(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
