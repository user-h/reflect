package com.hrbu.reflect;

import com.hrbu.Annotation.AutoWired;
import com.hrbu.Annotation.Bean;
import com.hrbu.dao.IBookDao;
import com.hrbu.dao.IUserDao;
import com.hrbu.dao.impl.BookDaoImpl;
import com.hrbu.dao.impl.UserDaoImpl;
import com.hrbu.service.IBookService;
import com.hrbu.service.IUserService;
import com.hrbu.service.impl.BookServiceImpl;
import com.hrbu.service.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ApplicationContext<T> {

    private HashMap<Class, Object> beanFactory = new HashMap<>();
    private String filePath;


    public T getBean(Class clazz) {
        return (T) beanFactory.get(clazz);
    }

    /**
     * 第二种方式 反射 (配置文件映射)
     */
    public void initContext() {
        /*
        beanFactory.put(IUserDao.class, (T) new UserDaoImpl());
        beanFactory.put(IBookDao.class, (T) new BookDaoImpl());
        beanFactory.put(IUserService.class, (T) new UserServiceImpl());
        beanFactory.put(IBookService.class, (T) new BookServiceImpl());
         */
        InputStream resource = ApplicationContext.class.getClassLoader()
                .getResourceAsStream("com\\config\\bean.config");
        Properties properties = new Properties();

        try {
            properties.load(resource);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                beanFactory.put(Class.forName(key.toString()),
                        Class.forName(properties.getProperty(key.toString())).newInstance());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第三种方式  注解 (自动扫描文件)
     */
    public void initContextByAnnotation() {
        // 扫描包 (之前)1.创建注解 2.加注解
        // 注意:这里类路径不能有空格  即项目路径不能有空格
        filePath = ApplicationContext.class.getClassLoader().getResource("").getFile();
        loadOne(new File(filePath));
        assembleObject();
    }

    public void load(){
        System.out.println(ApplicationContext.class.getClassLoader().getResource("").getFile());
    }


    /**
     * 实现自动装配
     */
    //是不是给所有的字符赋值
    private void assembleObject() {
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            //就是咱们放在容器的对象
            Object obj = entry.getValue();
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                AutoWired annotation = field.getAnnotation(AutoWired.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        System.out.println("正在给【" + obj.getClass().getName() + "】属性【" + field.getName() + "】注入值【" + beanFactory.get(field.getType()).getClass().getName() + "】");
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 加载一个文件夹的类
     *
     * @param fileParent
     */
    private void loadOne(File fileParent) {
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            for (File child : childrenFiles) {
                if (child.isDirectory()) {
                    //如果是个文件夹就继续调用该方法,使用了递归
                    loadOne(child);
                } else {
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    //  D:\mytools
                    //  com\xinzhi\dao\UserDao.class
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                    //选中class文件
                    if (pathWithClass.contains(".class")) {
                        //    com.xinzhi.dao.UserDao
                        //去掉.class后缀，并且把 \ 替换成 .
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);

                            //把非接口的类实例化放在map中
                            if (!aClass.isInterface()) {
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                if (annotation != null) {
                                    Object instance = aClass.newInstance();
                                    //判断一下有没有接口
                                    if (aClass.getInterfaces().length > 0) {
                                        //如果有接口把接口的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getInterfaces()[0] + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass.getInterfaces()[0], instance);
                                    } else {
                                        //如果有接口把自己的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getName() + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass, instance);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}

