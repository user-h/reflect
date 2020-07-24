package org.example.ORMapping.dao.impl;

import org.example.ORMapping.entity.User;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

public class BaseDAOImplTest {

    @Test
    public void Test01(){
        User user = new User("阿狸", 25, new Date());

        BaseDAOImpl dao = new BaseDAOImpl();
        // 返回id
        Serializable id = dao.save(user);
        System.out.println("id:" + id);
    }

    @Test
    public void Test02(){
        BaseDAOImpl dao = new BaseDAOImpl();

        for (int i = 0; i < 10; i++) {
            User user = new User("阿离" + i, 25+i, new Date());
            // 返回id
            Serializable id = dao.save(user);
            System.out.println("id:" + id);
        }
    }
}
