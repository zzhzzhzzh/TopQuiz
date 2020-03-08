package com.topQuiz.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * database util class
 * @author jady
 *
 */
public class DbUtil {
	//You may need to changes those fields to adapt to your db
	private String dbUrl = "jdbc:mysql://localhost:3306/QUESTION";
	private String dbUserName = "root";
	private String dbPassword = "barcelona";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * get db connection
	 * @return
	 * @throws Exception
	 */
	// 反射
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	    return con;
	}
	
	/**
	 * close db connection
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
