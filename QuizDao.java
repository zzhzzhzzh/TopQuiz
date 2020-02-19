package com.topQuiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.topQuiz.model.Quiz;
import com.topQuiz.model.QuizType;
import com.topQuiz.util.StringUtil;

/**
 * quiz dao
 * @author jady
 *
 */
public class QuizDao {

	/**
	 * update quiz
	 * @param con
	 * @param quizType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Quiz quiz) throws Exception{
		String sql = "update t_quiz set ques=?,ans=?,quizTypeId=?,quizDesc=? where id=?";
	    PreparedStatement pstmt = con.prepareStatement(sql);

	    pstmt.setString(1, quiz.getQues());
	    pstmt.setString(2, quiz.getAns());
	    pstmt.setInt(3, quiz.getQuizTypeId());
	    pstmt.setString(4, quiz.getQuizDesc());
	    pstmt.setInt(5, quiz.getId());

	    return pstmt.executeUpdate();
	}

	/**
	 * delete quiz
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception{
		String sql = "delete from t_quiz where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * list the required result set
	 * @param con
	 * @param quiz
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Quiz quiz) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_quiz q, t_quizType qt where q.quizTypeId=qt.id");

		// search under question, answer and quiz type
		if (StringUtil.isNotEmpty(quiz.getQues())) {
			sb.append(" and q.ques like '%" + quiz.getQues() + "%'");
		}
		if (StringUtil.isNotEmpty(quiz.getAns())) {
			sb.append(" and q.ans like '%" + quiz.getAns() + "%'");
		}
	    if (quiz.getQuizTypeId() != null && quiz.getQuizTypeId() != -1) {
	    	sb.append(" and q.quizTypeId=" + quiz.getQuizTypeId());
	    }

	    PreparedStatement pstmt = con.prepareStatement(sb.toString());
	    return pstmt.executeQuery();
	}

	/**
	 * add quiz
	 * @param con
	 * @param quiz
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Quiz quiz) throws Exception {
	    String sql = "insert into t_quiz values(null,?,?,?,?)";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, quiz.getQues());
	    pstmt.setString(2, quiz.getAns());
	    pstmt.setInt(3, quiz.getQuizTypeId());
	    pstmt.setString(4, quiz.getQuizDesc());
	    return pstmt.executeUpdate(); // return affected rows
	}

	/**
	 * return whether the type contain quiz
	 * @param con
	 * @param quizTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existQuizByQuizTypeId(Connection con, String quizTypeId) throws Exception {
		String sql = "select * from t_quiz where quizTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, quizTypeId);
	    ResultSet rs = pstmt.executeQuery();
	    return rs.next();
	}
}
