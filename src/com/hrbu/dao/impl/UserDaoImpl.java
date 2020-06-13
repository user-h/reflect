package com.hrbu.dao.impl;

import com.hrbu.Annotation.Bean;
import com.hrbu.dao.IUserDao;
import com.hrbu.entity.User;

import java.util.List;

/**
 * @author Lenovo
 * @date 2020/06/13
 */
@Bean
public class UserDaoImpl implements IUserDao {
    @Override
    public User finUserById(int id) {
        System.out.println("dao-这是finUserById");
        return null;
    }

    @Override
    public List<User> findAllUser() {
        System.out.println("dao-这是findAllUser");
        return null;
    }

    @Override
    public User findUserByUserName() {
        System.out.println("dao-这是findUserByUserName");
        return null;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("dao-这是saveUser");
    }
}
