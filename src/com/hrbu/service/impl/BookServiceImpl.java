package com.hrbu.service.impl;

import com.hrbu.Annotation.AutoWired;
import com.hrbu.Annotation.Bean;
import com.hrbu.dao.IBookDao;
import com.hrbu.dao.IUserDao;
import com.hrbu.dao.impl.BookDaoImpl;
import com.hrbu.dao.impl.UserDaoImpl;
import com.hrbu.entity.Book;
import com.hrbu.entity.User;
import com.hrbu.service.IBookService;

import java.util.List;

@Bean
public class BookServiceImpl implements IBookService {

    /**
     * 第一种方式  会创建重复的对象
     */
    //private IUserDao userDao = new UserDaoImpl();
    //private IBookDao bookDao = new BookDaoImpl();

    /**
     * 3
     */
    @AutoWired
    private IUserDao iUserDao;
    @AutoWired
    private IBookDao iBookDao;

    @Override
    public void borrow(User user, Book book) {
        List<User> users = iUserDao.findAllUser();
        System.out.println(user.getUsername() + "借了" + book.getName());
    }
}
