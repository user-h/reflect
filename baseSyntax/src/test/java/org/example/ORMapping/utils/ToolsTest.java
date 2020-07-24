package org.example.ORMapping.utils;

import org.example.ORMapping.entity.User;
import org.junit.Test;

import java.lang.reflect.Field;

public class ToolsTest {
    @Test
    public void Test01(){
        System.out.println(Tools.getTable(User.class));
    }

    @Test
    public void Test02() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("org.example.ORMapping.entity.User");

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(Tools.getColumn(field));
        }

    }

    @Test
    public void Test03() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("org.example.ORMapping.entity.User");

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(Tools.getMethod(field));
        }

    }
}
