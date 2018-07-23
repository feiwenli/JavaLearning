package com.hand;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();

            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl();
            User tom = new User();
            tom.setName("Tom");
            tom.setPassword("123");
            tom.setEmail("tom@qq.com");

            userDao.save(conn, tom);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
