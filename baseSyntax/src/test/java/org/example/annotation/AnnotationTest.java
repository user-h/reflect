package org.example.annotation;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 结合反射获取注解
 */

public class AnnotationTest {

    @Test
    public void Test01() throws Exception {
        Class<?> clazz = Class.forName("org.example.annotation.Animal");

        // 判断Class是否包含某个注解
        boolean isAnnotation = clazz.isAnnotationPresent(MyBean.class);

        // 获取注解的成员变量
        if (isAnnotation){
            MyBean myBean = clazz.getAnnotation(MyBean.class);
            if (myBean != null){
                System.out.println(myBean);
                System.out.println(myBean.table() + " : " + myBean.from());
            }
        }
    }

    @Test
    public void Test02() throws Exception {
        Class<?> clazz = Class.forName("org.example.annotation.Animal");

        // 获取属性上的注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            MyField myMethod = field.getAnnotation(MyField.class);
            if (myMethod != null) {
                System.out.println(field.getName() + " : " + myMethod.field());
            }
        }
    }
}
