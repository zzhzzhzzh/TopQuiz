package com.topQuiz.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * database util class
 * @author jady
 *
 */
public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/QUESTION";
	private String dbUserName = "root";
	private String dbPassword = "1111111";
	private String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * get connection with db
	 * @return
	 * @throws Exception
	 */

	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	    return con;
	}

	/**
	 * close connection with db
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if (con != null) {
			con.close(); 
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("succesful!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fails!");
		}
	}
}
