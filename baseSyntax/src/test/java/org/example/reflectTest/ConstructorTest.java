package org.example.reflectTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射调用构造器
 * 1.如何获取构造器 getConstructor/ getConstructors
 * 2.如何使用指定构造器实例对象 newInstance
 */
public class ConstructorTest {
    /**
     * 1.获取构造器
     * @throws ClassNotFoundException
     */
    @Test
    public void Test01() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");
        // 获取构造函数
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            // 打印构造器名字
            System.out.println(constructor.getName());

            // 获取参数类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            // 打印参数类型
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }
    }

    /**
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void Test02() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");

        // 获取指定构造器
        Constructor<?> constructor = clazz.getConstructor(String.class, String.class, Integer.class);
        // 创建实例对象
        Object o = constructor.newInstance("ai", "男", 22);
        // 打印对象
        System.out.println(o);
    }
}