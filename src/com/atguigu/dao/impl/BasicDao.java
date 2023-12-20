package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {
    private QueryRunner queryRunner=new QueryRunner();

    public int update(String sql,Object...parameters){
        int updateRow;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            updateRow = queryRunner.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 

        return updateRow;
    }

    public List<T> queryMulti(String sql,Class<T> clazz,Object...parameters)
    {Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            List<T> query = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T queryLine(String sql,Class<T> clazz,Object...parameters)
    {Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            T line = queryRunner.query(connection, sql, new BeanHandler<>(clazz), parameters);
            return line;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Object queryObject(String sql,Object...parameters)
    {Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Object o = queryRunner.query(connection, sql, new ScalarHandler(), parameters);
            return  o;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
