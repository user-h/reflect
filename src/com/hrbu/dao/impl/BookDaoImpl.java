package com.hrbu.dao.impl;

import com.hrbu.Annotation.Bean;
import com.hrbu.dao.IBookDao;
import com.hrbu.entity.Book;

import java.util.List;

@Bean
public class BookDaoImpl implements IBookDao {
    @Override
    public Book finUserById(int id) {
        return null;
    }

    @Override
    public List<Book> findAllUser() {
        return null;
    }

    @Override
    public void saveUser(Book book) {

    }
}
