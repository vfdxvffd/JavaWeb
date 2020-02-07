package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlZhuru {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // �û�����һ��Ϊroot
	private static final String PASSWORD = "123456"; // ���ݿ������
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static void Query() {
		Connection connection = null;		//��������
 		Statement stmt = null;				//����sql�ľ��
 		ResultSet rs = null;						//��ѯ�Ľ����
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			String phone= input.nextLine();
			String sql = "select count(*) from entries where name='"+name+"' and phone='"+phone+"';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);	//����ֵ��ʾ��ɾ�� ��������
			/**
			 * rs������һ��ָ�룬��ʼĬ��ָ���0�����ݣ����������һ��ʹ��
			 * 1������
			 * 2���ж�����֮���Ԫ���Ƿ�Ϊ��
			 * next()Ϊ�շ���false����Ϊ�շ���true
			 */
			while(rs.next() == true) {
				
				int count = rs.getInt(1);
				if(count > 0) {
					System.out.println("��½�ɹ���");
				}else {
					System.out.println("��½ʧ�ܣ�");
				}
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
	
	public static void main(String[] args) {
		Query();
	}
}
