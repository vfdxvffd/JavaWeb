package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlZhuru {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // 用户名，一般为root
	private static final String PASSWORD = "123456"; // 数据库的密码
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static void Query() {
		Connection connection = null;		//建立连接
 		Statement stmt = null;				//发送sql的句柄
 		ResultSet rs = null;						//查询的结果集
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			String phone= input.nextLine();
			String sql = "select count(*) from entries where name='"+name+"' and phone='"+phone+"';";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);	//返回值表示增删改 几条数据
			/**
			 * rs就像是一个指针，初始默认指向第0行数据，就像迭代器一样使用
			 * 1、下移
			 * 2、判断下移之后的元素是否为空
			 * next()为空返回false，不为空返回true
			 */
			while(rs.next() == true) {
				
				int count = rs.getInt(1);
				if(count > 0) {
					System.out.println("登陆成功！");
				}else {
					System.out.println("登陆失败！");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
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
	}
	
	public static void main(String[] args) {
		Query();
	}
}
