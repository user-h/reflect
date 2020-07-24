package com.hrbu;

import com.hrbu.dao.IBookDao;
import com.hrbu.dao.IUserDao;
import com.hrbu.dao.impl.BookDaoImpl;
import com.hrbu.entity.Book;
import com.hrbu.entity.User;
import com.hrbu.reflect.ApplicationContext;
import com.hrbu.service.IBookService;

public class BootStrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();

        // 第二种方法测试
        //applicationContext.initContext();
        //System.out.println(applicationContext.getBean(IBookDao.class));

        // 第三种方法测试
        //applicationContext.load();

        /*applicationContext.initContextByAnnotation();
        Object bean = applicationContext.getBean(IBookDao.class);
        System.out.println(bean);*/

        applicationContext.initContextByAnnotation();
        IBookService iBookService = (IBookService)applicationContext.getBean(IBookService.class);
        iBookService.borrow(
                new User("1", "张三", "123", 22),
                new Book("1001", "《精通特征工程》")
        );
    }

}
