package org.example.ORMapping.dao;

import java.io.Serializable;

public interface BaseDAO {

    /**
     * insert into xxx (col1, col2, col3 ...) values (?,?,? ...)
     * @param t
     * @param <T>
     * @return
     */
    <T> Serializable save(T t);
}
