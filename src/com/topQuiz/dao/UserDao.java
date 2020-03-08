package com.topQuiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public ResultSet search(Connection con, String username) throws Exception {
        String sql = "select * from t_UserInfo where username=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        return pstmt.executeQuery();
    }
}
