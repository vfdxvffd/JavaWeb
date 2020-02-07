package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDao {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // �û�����һ��Ϊroot
	private static final String PASSWORD = "123456"; // ���ݿ������
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public int login(String name, String pwd) {
		Connection connection = null;		//��������
 		Statement stmt = null;				//����sql�ľ��
 		ResultSet rs = null;						//��ѯ�Ľ����
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			String sql = "select count(*) from user where name='"+name+"' and pwd='"+pwd+"';";
			rs = stmt.executeQuery(sql);	//����ֵ��ʾ��ɾ�� ��������
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
			try {		//�رյ�˳��ͺ�ջһ�����ȿ��ĺ��
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
