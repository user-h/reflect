package org.example.reflectTest;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 1)如何获取到执行的Method/参数  clazz.getDeclaredMethod/method.getParameterTypes
 * 2)如何动态调用Method invoke
 */
public class MethodTest {

    /**
     * 1.获取方法及参数
     * @throws ClassNotFoundException
     */
    @Test
    public void Test01() throws ClassNotFoundException {
        // 获取类对象
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");
        // 获取方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // 打印所有方法名
            //System.out.println(method.getName());

            // 获取方法参数(只限有参数的方法)
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                // 打印方法名和参数类型
                System.out.println(method.getName() + "---" + parameterType.getName());
            }
        }
    }

    /**
     * 2.调用方法
     * @throws ClassNotFoundException
     */
    @Test
    public void Test02() throws Exception {
        // 获取类对象
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");
        // 创建实例
        Object obj = clazz.newInstance();

        // 调用set方法赋值
        Method setAge = clazz.getDeclaredMethod("setAge", Integer.class);
        setAge.invoke(obj, 128);
        System.out.println(obj);

        // 调用get方法
        Method getAge = clazz.getDeclaredMethod("getAge");
        Object invoke = getAge.invoke(obj);
        System.out.println(invoke);
    }
}
