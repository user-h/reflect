package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
// 注解可以在运行时加载
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
    String field();
}
