package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解学习
 */

// 注解在哪里起作用
/** Class, interface (including annotation type), or enum declaration */
@Target(ElementType.TYPE)
// 注解可以在运行时加载
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBean {

    // 注解的属性叫成员变量
    String table();

    String from() default "";
}
