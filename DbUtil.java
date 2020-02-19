{\rtf1\ansi\ansicpg936\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 package com.topQuiz.util;\
\
import java.sql.Connection;\
import java.sql.DriverManager;\
\
/**\
 * database util class\
 * @author jady\
 *\
 */\
public class DbUtil \{\
	private String dbUrl = "jdbc:mysql://localhost:3306/QUESTION";\
	private String dbUserName = "root";\
	private String dbPassword = "1111111";\
	private String jdbcName = "com.mysql.jdbc.Driver";\
	\
	/**\
	 * 
\f1 \'bb\'f1\'c8\'a1\'ca\'fd\'be\'dd\'bf\'e2\'c1\'ac\'bd\'d3
\f0 \
	 * @return\
	 * @throws Exception\
	 */\
	// 
\f1 \'b7\'b4\'c9\'e4
\f0 \
	public Connection getCon() throws Exception\{\
		Class.forName(jdbcName);//
\f1 \'b7\'b4\'c9\'e4\'bc\'d3\'d4\'d8\'c0\'e0\'a3\'ac\'ca\'b5\'c0\'fd\'bb\'af
\f0 \
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);\
	    return con;\
	\}\
	\
	/**\
	 * 
\f1 \'b9\'d8\'b1\'d5\'ca\'fd\'be\'dd\'bf\'e2\'c1\'ac\'bd\'d3
\f0 \
	 * @param con\
	 * @throws Exception\
	 */	\
	public void closeCon(Connection con) throws Exception\{\
		if (con != null) \{\
			con.close(); //con
\f1 \'d5\'bc\'b5\'c4\'d7\'ca\'d4\'b4\'ba\'dc\'b6\'e0\'a3\'ac\'d2\'bb\'b6\'a8\'d2\'aa\'b9\'d8\'b1\'d5
\f0 \
		\}\
	\}\
	\
	public static void main(String[] args) \{\
		DbUtil dbUtil = new DbUtil();\
		try \{\
			dbUtil.getCon();\
			System.out.println("succesful!");\
		\} catch (Exception e) \{\
			// TODO Auto-generated catch block\
			e.printStackTrace();\
			System.out.println("fails!");\
		\}\
	\}\
\}\
}