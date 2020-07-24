package org.example.reflectTest;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorTest {

    /**
     * 获取方法或属性
     * @throws Exception
     */
    @Test
    public void Test01() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(MyStudent.class);

        // 获取方法描述
        /*MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        for (MethodDescriptor methodDescriptor : methodDescriptors) {
            System.out.println(methodDescriptor.getName() + " : " + methodDescriptor.getMethod());
        }*/

        // 获取属性描述
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getName());
        }
    }

    /**
     * 属性描述器的简单使用
     */
    @Test
    public void Test02() throws Exception {
        MyStudent myStudent = new MyStudent();

        // 创建属性描述器
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", MyStudent.class);

        // 获取set方法
        Method setmethod = propertyDescriptor.getWriteMethod();
        setmethod.invoke(myStudent, "阿狸");
        System.out.println(myStudent.getName());

        // 获取get方法
        Method getMethod = propertyDescriptor.getReadMethod();
        System.out.println(getMethod.invoke(myStudent));


        // 获取参数类型
        System.out.println(propertyDescriptor.getPropertyType());
    }
}
