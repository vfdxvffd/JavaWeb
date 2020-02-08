package org.first.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.first.entity.userBean;

//模型层，用于处理登陆(查询数据库)
public class loginDao {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/exercise?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // 用户名，一般为root
	private static final String PASSWORD = "123456"; // 数据库的密码
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public int login(userBean user) {	//登陆
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "select count(*) from login where uname=? and upwd=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
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
			try {
				if(rs != null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(connection != null)	connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
