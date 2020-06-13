package com.hrbu.dao;

import com.hrbu.entity.User;

import java.util.List;

public interface IUserDao {

    /**
     * 根据id找到User
     * @param id
     * @return
     */
    User finUserById(int id);

    /**
     * 获取所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据用户名获取用户
     * @return
     */
    User findUserByUserName();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
