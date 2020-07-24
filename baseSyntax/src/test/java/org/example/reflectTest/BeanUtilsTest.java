package org.example.reflectTest;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.HashMap;

public class BeanUtilsTest {
    /**
     * 通过BeanUtils设置属性
     * @throws Exception
     */
    @Test
    public void Test01() throws Exception {
        MyStudent myStudent = new MyStudent();

        // 导入commons-beanutils依赖
        BeanUtils.setProperty(myStudent, "name", "阿离");
        System.out.println(myStudent);

    }

    /**
     * 快速放多个值
     */
    @Test
    public void Test02() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "阿离");
        map.put("sex", "男");
        map.put("age", 25);

        MyStudent myStudent = new MyStudent();
        BeanUtils.populate(myStudent, map);

        System.out.println(myStudent);
    }
}
