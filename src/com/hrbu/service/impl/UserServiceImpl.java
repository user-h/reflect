package com.hrbu.service.impl;

import com.hrbu.Annotation.Bean;
import com.hrbu.dao.IUserDao;
import com.hrbu.dao.impl.UserDaoImpl;
import com.hrbu.entity.User;
import com.hrbu.service.IUserService;

@Bean
public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public void login() {
        userDao.findUserByUserName();
        System.out.println("这是登录业务的实现方法");
    }

    @Override
    public void regist() {
        userDao.saveUser(new User("1", "12", "123456789", 22));
        System.out.println("这是注册业务的实现方法");
    }

}
