package com.example.springboot.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 使用@Compoent 把这个类纳入到Spring 容器，@Aspect注解表示这个类是一个切面类
 */
@Component
@Aspect
public class BeforeAop {
    /**
     * 定义一个前置通知
     * 匹配com.example.springboot.config 包及其子包下到所有方法
     */
    @Before("execution(* com.example.springboot..*.*(..))")
    public void log() {
        System.out.println("...before...");
    }
}
