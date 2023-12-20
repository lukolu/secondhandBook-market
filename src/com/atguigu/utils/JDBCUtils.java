package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource=null;
    private static ThreadLocal<Connection> connectionThreadLocal=new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = connectionThreadLocal.get();
        if (connection==null) {
            connection= dataSource.getConnection();
            connectionThreadLocal.set(connection);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public static void commitAndClose() {
        Connection connection = connectionThreadLocal.get();
        if (connection!=null)
        {
            try {
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        connectionThreadLocal.remove();
    }

    public static void rollbackAndClose() {
        Connection connection = connectionThreadLocal.get();
        if (connection!=null)
        {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            connectionThreadLocal.remove();

        }
    }

//    public static void closeConnection(ResultSet resultSet, Connection connection, Statement statement) {
//        try {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
