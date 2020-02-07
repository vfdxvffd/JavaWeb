package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDao {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // 用户名，一般为root
	private static final String PASSWORD = "123456"; // 数据库的密码
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public int login(String name, String pwd) {
		Connection connection = null;		//建立连接
 		Statement stmt = null;				//发送sql的句柄
 		ResultSet rs = null;						//查询的结果集
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			String sql = "select count(*) from user where name='"+name+"' and pwd='"+pwd+"';";
			rs = stmt.executeQuery(sql);	//返回值表示增删改 几条数据
			while(rs.next() == true) {
				int count = rs.getInt(1);
				if(count == 1) {
					return 1;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {		//关闭的顺序就和栈一样，先开的后关
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
