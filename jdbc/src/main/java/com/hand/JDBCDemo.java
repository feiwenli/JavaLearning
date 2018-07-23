package com.hand;

import java.sql.*;

public class JDBCDemo {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/aaoo","root","1234567");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void insert(){
        Connection conn = getConnection();
        try{
            String sql = "INSERT INTO tbl_user(name, password, email)" +
                    "VALUES('Tom','12345','tom@gmail.com')";
            Statement st = conn.createStatement();

            int count = st.executeUpdate(sql);  //可以执行insert,updata,delete,dml,ddl
            System.out.println("向用户表中插入了"+count+"条记录。");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(){
        Connection conn = getConnection();
        try{
            String sql = "UPDATE tbl_user SET email='Tom@163.com' WHERE name='Tom'";
            Statement st = conn.createStatement();

            int count = st.executeUpdate(sql);  //可以执行insert,updata,delete,dml,ddl
            System.out.println("向用户表中修改了"+count+"条记录。");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(){
        Connection conn = getConnection();
        try{
            String sql = "DELETE FROM tbl_user WHERE name = 'Tom'";
            Statement st = conn.createStatement();

            int count = st.executeUpdate(sql);  //可以执行insert,updata,delete,dml,ddl
            System.out.println("向用户表中删除了"+count+"条记录。");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getValue(){
        Connection conn = getConnection();
        String sql = "SELECT * FROM tbl_user";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                System.out.print(rs.getInt("id")+"  ");
                System.out.print(rs.getString("name")+"  ");
                System.out.print(rs.getString("password")+"  ");
                System.out.print(rs.getString("email")+ "  ");
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args){

        delete();

    }
}
