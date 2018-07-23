package com.hand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务
 */

public class TransactionDemo {

    public static Connection getConnection(Connection conn){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/aaoo","root","1234567");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void insertUserData(Connection conn) throws SQLException {

        String sql = "INSERT INTO tbl_user(name, password, email)" +
                "VALUES('Amy','12345','Amy@gmail.com')";
        Statement st = conn.createStatement();

        int count = st.executeUpdate(sql);  //可以执行insert,updata,delete,dml,ddl
        System.out.println("向用户表中插入了"+count+"条记录。");

    }

    public static void insertAddressData(Connection conn) throws SQLException {

        String sql = "INSERT INTO tbl_address(id, city, country)" +
                "VALUES(1, 'shanghai', 'china', '10')";
        Statement st = conn.createStatement();

        int count = st.executeUpdate(sql);  //可以执行insert,updata,delete,dml,ddl
        System.out.println("向地址表中插入了"+count+"条记录。");

    }
    public static void main(String [] arga){

        Connection conn = null;

        try {
            conn = getConnection(conn);

            /**
             * 1. 当开启autocommit=true时，回滚没有意义，无论成功/失败都已经已经将事务提交
             * 2. 只有autocommit=false，成功时手动调用conn.commit(), 失败也是手动调用conn.rollback();
             */
            conn.setAutoCommit(false);
            insertUserData(conn);
            insertAddressData(conn);
            conn.commit();

        } catch (SQLException e) {
            System.out.println("====================捕获sql异常====================>");
            e.printStackTrace();
            try{
                conn.rollback();
                System.out.println("====================事务回滚成功====================>");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                try{
                    if (conn!=null){
                        conn.close();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
