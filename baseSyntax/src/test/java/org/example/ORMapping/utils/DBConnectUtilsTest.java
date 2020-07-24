package org.example.ORMapping.utils;

import org.junit.Test;

public class DBConnectUtilsTest {
    @Test
    public void Test01(){
        System.out.println(DBConnectUtils.getConnect());
        DBConnectUtils.close();
    }
}
