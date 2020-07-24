package org.example.reflectTest;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 获取类对象
 * 1.Class.forName
 * 2.Class.class/Object.getClass方式获取类对象
 * 3. .getSuperclass获取父类类对象
 */
public class ReflectionClassTest {

    /**
     *  1.Class.forName获取类对象
     * @throws ClassNotFoundException
     */
    @Test
    public void Test01() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.Object");
        System.out.println(clazz);

        // .获取方法 (包括私有)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("--------------------------------------------");

        // .获取方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 2.Class.class/Object.getClass方式获取类对象
     */
    @Test
    public void Test02(){
        String str = "张三";
        Class<?> clazz = str.getClass();
        System.out.println(clazz);

        Class<?> clazz2 = String.class;
        System.out.println(clazz2);

        System.out.println(Integer.class);
        System.out.println(Integer.TYPE);
    }

    /**
     * 3. .getSuperclass获取父类类对象
     */
    @Test
    public void Test03(){
        Class<?> classType = Student.class;
        System.out.println(classType);

        // 3.获取父类类对象
        classType = classType.getSuperclass();
        System.out.println(classType);

        classType = classType.getSuperclass();
        System.out.println(classType);

        classType = classType.getSuperclass();
        System.out.println(classType);

    }

    @Test
    public void Test04() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三老师");
        list.add("李四老师");

        Class<?> clazz = list.getClass();
        System.out.println(clazz);

        // 4.反射调用方法
        Method method = clazz.getMethod("add", Object.class);   //.getDeclaredMethod()
        method.invoke(list, 1000);
        method.invoke(list, 10.0);
        method.invoke(list, "王五老师");

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}

class Person{}

class Student extends Person{}
