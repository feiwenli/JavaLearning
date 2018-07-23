package com.hand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    // 插入用户信息
    @Override
    public void save(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareCall("INSERT INTO tbl_user(name,password,email) VALUES (?,?,?)");

        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();

    }

    // 更新用户信息
    @Override
    public void update(Connection conn, Long id, User user) throws SQLException {

        String updateSql = "UPDATE tbl_user SET name = ?, password = ?, email = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(updateSql);

        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, id);
    }

    //删除用户信息
    @Override
    public void delete(Connection conn, User user) throws SQLException {
        String updateSql = "DELETE from tbl_user WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(updateSql);

        ps.setLong(1, user.getId());
        ps.execute();
    }
}
