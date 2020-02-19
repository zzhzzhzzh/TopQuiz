package com.topQuiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.topQuiz.model.QuizType;
import com.topQuiz.util.StringUtil;

/**
 * quiz type DAO
 * @author jady
 *
 */
public class QuizTypeDao {
	/**
	* add quiz types
	* @param con
	* @param quizType
	* @return
	* @throws Exception
	*/
	public int add(Connection con, QuizType quizType) throws Exception{
	    String sql = "insert into t_quizType values(null,?,?)";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, quizType.getQuizTypeName());
	    pstmt.setString(2, quizType.getQuizTypeDesc());
	    return pstmt.executeUpdate(); // return affected rows
	}

	/**
	 * list all quiz types
	 * @param con
	 * @param quizType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, QuizType quizType) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_quizType");
		if (StringUtil.isNotEmpty(quizType.getQuizTypeName())) {
			sb.append(" and quizTypeName like '%" + quizType.getQuizTypeName() + "%'");
		}

	    PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
	    return pstmt.executeQuery();
	}

	/**
	 * delete quiz type
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception{
		String sql = "delete from t_quizType where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * update quiz type
	 * @param con
	 * @param quizType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, QuizType quizType) throws Exception{
		String sql = "update t_quizType set quizTypeName=?,quizTypeDesc=? where id=?";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, quizType.getQuizTypeName());
	    pstmt.setString(2, quizType.getQuizTypeDesc());
	    pstmt.setInt(3, quizType.getId());
	    return pstmt.executeUpdate();
	}

}
