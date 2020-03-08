package com.topQuiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.topQuiz.model.BlankQuestion;
/**
 * blank question DAO
 * @author jady
 *
 */
public class BlankQuestionDao {

	/**
	* add blank question
	* @param con
	* @param blankQuestion
	* @return
	* @throws Exception
	*/
	public int add(Connection con, BlankQuestion blankQuestion) throws Exception{
	    String sql = "insert into t_blankQuestion values(null,?,?)";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, blankQuestion.getQuestion());
	    pstmt.setString(2, blankQuestion.getAnswer());
	    return pstmt.executeUpdate(); // return affected rows
	}

	public ResultSet search(Connection con) throws Exception {
		String sql = "select * from t_blankQuestion order by rand() limit 2";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}


	
}




