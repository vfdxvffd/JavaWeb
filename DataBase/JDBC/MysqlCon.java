package Mysql;

import java.sql.*;

public class MysqlCon {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/text?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root";
	private static final String PASSWORD = "123456";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		
		//ע��JDBC����
		Class.forName(JDBC_DRIVER);
		
		//������
		System.out.println("�������ݿ� ������");
		conn = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
		
		//ִ�в�ѯ
		System.out.println("ʵ����Statement���󡣡���");
		stmt = conn.createStatement();
		String sql;
		sql = "select id,name,money from bank";
		ResultSet rs = stmt.executeQuery(sql);
		
		//չ����������ݿ�
		while(rs.next())
		{
			//ͨ���ֶμ���
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String url = rs.getString("money");
			
			//�������
			System.out.print("ID: "+id);
			System.out.print(", ���֣�"+name);
			System.out.print(", ���:"+url);
			System.out.println();
		}
		
		//��ɺ�ر�
		rs.close();
		stmt.close();
		conn.close();
		
		System.out.println("GoodBye!");
	}
}
