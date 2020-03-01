package com.spring.simple.development.core.baseconfig.idempotent;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;



/**
 * 拦截接口幂等目标方法
 *
 * @author
 */
@Order(value = 1)
@Aspect
@Component
public class IdempotentAspect {
    @Pointcut("@annotation(com.spring.simple.development.core.annotation.base.Idempotent)")
    public void annotationPointcut() {
    }

    /**
     * 请求前置拦截
     *
     * @param point
     * @throws Exception
     */
    @Before("annotationPointcut()")
    public void before(JoinPoint point) throws Exception {
        Class<?> aClass = Class.forName("com.spring.simple.development.core.component.idempotent.IdempotentHandlerUtil");
        Method before = aClass.getMethod("before", point.getClass());
        before.invoke(aClass.newInstance(), point);
    }

    /**
     * 请求后置拦截
     *
     * @param point
     * @throws Exception
     */
    @After("annotationPointcut()")
    public void after(JoinPoint point) throws Exception {
        Class<?> aClass = Class.forName("com.spring.simple.development.core.component.idempotent.IdempotentHandlerUtil");
        Method after = aClass.getMethod("after", point.getClass());
        after.invoke(aClass.newInstance(), point);
    }
}
