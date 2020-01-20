package com.optimize.performance.aop;

import android.util.Log;

import com.optimize.performance.utils.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceAop {
    @Around("call(* com.optimize.performance.PerformanceApp.initFresco(..))")
    public void getTime(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.toShortString();
        long time = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // LogUtils.i(name + "PerformanceAop getTime cost " + (System.currentTimeMillis() - time));
    }

    // @Pointcut("@annotation(com.optimize.performance.aop.BehaviorTrace)")
    // public void pointcut() {
    // }
    //
    // @Before("pointcut()")
    // public void before(JoinPoint point) {
    //     Log.e("TAG", "PerformanceAop TestAnnoAspect before:");
    // }
    //
    // @Around("pointcut()")
    // public void around(ProceedingJoinPoint joinPoint) throws Throwable {
    //     Log.e("TAG", "PerformanceAop TestAnnoAspect around:");
    //     try {
    //         joinPoint.proceed();
    //     } catch (Throwable throwable) {
    //         throwable.printStackTrace();
    //     }
    // }
    //
    //
    // @After("pointcut()")
    // public void after(JoinPoint point) {
    //     Log.e("TAG", "TestAnnoAspect after:");
    // }
    //
    // @AfterReturning("pointcut()")
    // public void afterReturning(JoinPoint point, Object returnValue) {
    //     Log.e("TAG", "TestAnnoAspect afterReturning:");
    // }

    @Around("execution(* android.app.Activity.setContentView(..))")
    public void getSetContentViewTime(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.toShortString();
        long time = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // LogUtils.i(name + " cost " + (System.currentTimeMillis() - time));
    }





}
