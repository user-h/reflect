package com.hrbu.service;

import com.hrbu.entity.Book;
import com.hrbu.entity.User;

public interface IBookService {
    void borrow(User user, Book book);
}
