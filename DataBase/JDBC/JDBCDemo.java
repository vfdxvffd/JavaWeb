package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // �û�����һ��Ϊroot
	private static final String PASSWORD = "123456"; // ���ݿ������
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public static void update(){		//��ɾ�Ķ���һ���ģ�ֻ����Ҫ�޸�sql���
		
		Connection connection = null;		//��������
 		Statement stmt = null;				//����sql�ľ��
		
		try {
			//1����������
			Class.forName(JDBC_DRIVER);		//���ؾ����������
			//2�������ݿ⽨������
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
						
			//3������sql��ִ��(��ɾ��)
			stmt = connection.createStatement();
			
			//��ɾ��
			String sql = "insert into entries values ('zhangsan','2201');";
			int count = stmt.executeUpdate(sql);	//����ֵ��ʾ��ɾ�� ��������
			if(count > 0) {
				System.out.println("�ɹ���");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void query() {
		Connection connection = null;		//��������
 		Statement stmt = null;				//����sql�ľ��
 		ResultSet rs = null;						//��ѯ�Ľ����
		
		try {
			//1����������
			Class.forName(JDBC_DRIVER);		//���ؾ����������
			//2�������ݿ⽨������
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
						
			//3������sql��ִ��(��)
			stmt = connection.createStatement();
			
			//��,������
			String sql = "select * from entries;";
			rs = stmt.executeQuery(sql);	//����ֵ��ʾ��ɾ�� ��������
			/**
			 * rs������һ��ָ�룬��ʼĬ��ָ���0�����ݣ����������һ��ʹ��
			 * 1������
			 * 2���ж�����֮���Ԫ���Ƿ�Ϊ��
			 * next()Ϊ�շ���false����Ϊ�շ���true
			 */
			while(rs.next() == true) {
				//ʹ��getXXX������ȡ���ݣ�����������ʲô��getʲô���������ֶ���
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(name+"�ĺ�����"+phone);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
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
	}
	
	public static void PreparedUpdate() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			String sql = "insert into entries values (?,?);";		//��ռλ����������
			pstmt = connection.prepareStatement(sql);				//Ԥ����		
			//���ֶ�
			pstmt.setString(1, "wangwu");		//��һ������
			pstmt.setString(2, "10086");		//�ڶ����绰����������String���͵�����varchar
			
			int count = pstmt.executeUpdate();	//����ֵ��ʾ��ɾ�� ��������
			if(count > 0) {
				System.out.println("�ɹ���");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void PreparedQuery() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(JDBC_DRIVER);	
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			String sql = "select * from entries where name = ?;";			
			pstmt = connection.prepareStatement(sql);			//Ԥ����
			//���ֶ�
			pstmt.setString(1, "wangwu");

			rs = pstmt.executeQuery();	//����ֵ��ʾ��ɾ�� ��������
			while(rs.next() == true) {
				//ʹ��getXXX������ȡ���ݣ�����������ʲô��getʲô���������ֶ���
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(name+"�ĺ�����"+phone);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {		//�رյ�˳��ͺ�ջһ�����ȿ��ĺ��
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		PreparedQuery();
	}
}































