package com.spring.simple.development.core.annotation.base;

import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注册api service服务
 * @author liko
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface IsApiService {
    /**
     * 服务名
     *
     * @return
     */
    String value() default "";

    /**
     * 是否需要登录的服务
     *
     * @return
     */
    boolean isLogin() default true;
}