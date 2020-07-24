package org.example.ORMapping.utils;

import org.example.ORMapping.annotation.MyBean;
import org.example.ORMapping.annotation.MyField;

import java.lang.reflect.Field;

public class Tools {

    /**
     * 通过获取注解得到表名
     * @param clazz
     * @return
     */
    public static String getTable(Class<?> clazz){
        String tableName = "";

        MyBean annotation = clazz.getAnnotation(MyBean.class);
        if (annotation != null){
            tableName = annotation.value();
        } else {
            tableName = clazz.getSimpleName().toLowerCase();
        }

        return tableName;
    }

    /**
     * 通过获取注解得到属性名
     */
    public static String getColumn(Field field){
        String column = "";

        MyField fieldAnnotation = field.getAnnotation(MyField.class);
        if (fieldAnnotation != null) {
            column = fieldAnnotation.value();
        } else {
            column = field.getName();
        }

        return column;
    }

    public static String getMethod(Field field){
        char[] chars = field.getName().toCharArray();

        // id => getId name => getName
        if (97 <= chars[0] && chars[0]  <= 122){
            chars[0] -= 32;
        }
        StringBuilder builder = new StringBuilder("get").append(chars);
        return builder.toString();
    }
}
