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
		
		//注册JDBC驱动
		Class.forName(JDBC_DRIVER);
		
		//打开链接
		System.out.println("连接数据库 。。。");
		conn = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
		
		//执行查询
		System.out.println("实例化Statement对象。。。");
		stmt = conn.createStatement();
		String sql;
		sql = "select id,name,money from bank";
		ResultSet rs = stmt.executeQuery(sql);
		
		//展开结果集数据库
		while(rs.next())
		{
			//通过字段检索
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String url = rs.getString("money");
			
			//输出数据
			System.out.print("ID: "+id);
			System.out.print(", 名字："+name);
			System.out.print(", 存款:"+url);
			System.out.println();
		}
		
		//完成后关闭
		rs.close();
		stmt.close();
		conn.close();
		
		System.out.println("GoodBye!");
	}
}
