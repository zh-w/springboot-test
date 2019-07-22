package com.wz.test.SpringbootTest.aop;

import net.bytebuddy.asm.Advice.Return;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangzheng
 * @Date: 2019-07-14 11:13
 * @Description:
 */
@Aspect
@Component
public class AspectCase {

    @Pointcut("execution(* com.wz.test.SpringbootTest.aop.ApplicationBean.watchMove(..))")
    public void watchmove(){};

    @Before("watchmove()")
    public void check(){
        System.out.println("check ticket");
    }

    @After("watchmove()")
    public void takeGlass(){
        System.out.println("takeGlass");
    }

    @AfterReturning("watchmove()")
    public void washroom(){
        System.out.println("washroom");
    }

    @Around("watchmove()")
    public void allTime(ProceedingJoinPoint pd){
        try {
            System.out.println("aroud before");
            pd.proceed();
            System.out.println("aroud after");
        } catch (Throwable throwable) {
            System.out.println("aroud catch");
        }
    }

}
