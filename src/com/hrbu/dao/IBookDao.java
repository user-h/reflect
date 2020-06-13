package com.hrbu.dao;

import com.hrbu.entity.Book;

import java.util.List;

public interface IBookDao {
    /**
     * 根据id找到
     * @param id
     * @return
     */
    Book finUserById(int id);

    /**
     * 获取所有
     * @return
     */
    List<Book> findAllUser();

    /**
     * 保存Book
     * @param book
     */
    void saveUser(Book book);
}
