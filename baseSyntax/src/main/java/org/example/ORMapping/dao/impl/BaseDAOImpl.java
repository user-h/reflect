package org.example.ORMapping.dao.impl;

import org.example.ORMapping.dao.BaseDAO;
import org.example.ORMapping.utils.DBConnectUtils;
import org.example.ORMapping.utils.Tools;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDAOImpl implements BaseDAO {

    /**
     * 入参是T
     * insert into t_user(name,age,birth_day) values (?,?,?)
     * @param t
     * @param <T>
     * @return
     */
    @Override
    public <T> Serializable save(T t) {
        Class<?> clazz = t.getClass();
        StringBuilder sql = new StringBuilder("insert into ");

        // 获取表名
        String table = Tools.getTable(clazz);
        sql.append(table).append("(");

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!"id".equals(declaredField.getName())) {
                // 获取属性名
                sql.append(Tools.getColumn(declaredField)).append(",");
            }
        }
        // 去掉最后一个 ,
        sql.deleteCharAt(sql.toString().length() - 1).append(") values (");

        for (Field declaredField : declaredFields) {
            if (!"id".equals(declaredField.getName())) {
                sql.append("?,");
            }
        }
        // 去掉最后一个 ,
        sql.deleteCharAt(sql.toString().length() - 1).append(")");
        //System.out.println(sql.toString());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectUtils.getConnect();
            //preparedStatement = connection.prepareStatement(String.valueOf(sql));
            // Sql语句 + 需要返回的数据
            preparedStatement = connection.prepareStatement(String.valueOf(sql),
                    new String[]{"id"});

            int index = 1;
            for (Field declaredField : declaredFields) {
                if (!"id".equals(declaredField.getName())) {
                    String getMethod = Tools.getMethod(declaredField);
                    Method declaredMethod = clazz.getDeclaredMethod(getMethod);
                    Object invoke = declaredMethod.invoke(t);
                    preparedStatement.setObject(index++, invoke);
                }
            }
            int rowCount = preparedStatement.executeUpdate();
            System.out.println("rowCount: " + rowCount);

            if (rowCount > 0){
                resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                return (Serializable)resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
