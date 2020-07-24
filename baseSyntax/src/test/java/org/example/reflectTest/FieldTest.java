package org.example.reflectTest;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest {

    /**
     * 获取属性
     */
    @Test
    public void Test01() throws Exception {
        // 获取类对象
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");

        // 获取属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " : " + declaredField.getType());
        }
        System.out.println("====================");

        // 获取单个方法
        Field age = clazz.getDeclaredField("age");
        System.out.println(age.getName() + " : " + age.getType());

    }

    /**
     * 修改私有属性
     */
    @Test
    public void Test02() throws Exception {
        // 获取类对象
        Class<?> clazz = Class.forName("org.example.reflectTest.MyStudent");

        //创建实例 获取属性
        MyStudent myStu = (MyStudent)clazz.newInstance();
        Field name = clazz.getDeclaredField("name");

        // 如果属性不可访问  设置为可以访问
        if (!name.isAccessible()){
            name.setAccessible(true);
        }

        // 设置属性的值
        name.set(myStu, "阿离");
        System.out.println(myStu);
    }
}
