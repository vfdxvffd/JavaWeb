package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // 用户名，一般为root
	private static final String PASSWORD = "123456"; // 数据库的密码
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public static void update(){		//增删改都是一样的，只是需要修改sql语句
		
		Connection connection = null;		//建立连接
 		Statement stmt = null;				//发送sql的句柄
		
		try {
			//1、导入驱动
			Class.forName(JDBC_DRIVER);		//加载具体的驱动类
			//2、与数据库建立连接
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
						
			//3、发送sql，执行(增删改)
			stmt = connection.createStatement();
			
			//增删改
			String sql = "insert into entries values ('zhangsan','2201');";
			int count = stmt.executeUpdate(sql);	//返回值表示增删改 几条数据
			if(count > 0) {
				System.out.println("成功！");
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
		Connection connection = null;		//建立连接
 		Statement stmt = null;				//发送sql的句柄
 		ResultSet rs = null;						//查询的结果集
		
		try {
			//1、导入驱动
			Class.forName(JDBC_DRIVER);		//加载具体的驱动类
			//2、与数据库建立连接
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
						
			//3、发送sql，执行(查)
			stmt = connection.createStatement();
			
			//查,处理结果
			String sql = "select * from entries;";
			rs = stmt.executeQuery(sql);	//返回值表示增删改 几条数据
			/**
			 * rs就像是一个指针，初始默认指向第0行数据，就像迭代器一样使用
			 * 1、下移
			 * 2、判断下移之后的元素是否为空
			 * next()为空返回false，不为空返回true
			 */
			while(rs.next() == true) {
				//使用getXXX函数获取数据，数据类型是什么就get什么，参数是字段名
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(name+"的号码是"+phone);
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
	
	public static void PreparedUpdate() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
			String sql = "insert into entries values (?,?);";		//用占位符代替数据
			pstmt = connection.prepareStatement(sql);				//预编译		
			//绑定字段
			pstmt.setString(1, "wangwu");		//第一个姓名
			pstmt.setString(2, "10086");		//第二个电话，两个都是String类型的数据varchar
			
			int count = pstmt.executeUpdate();	//返回值表示增删改 几条数据
			if(count > 0) {
				System.out.println("成功！");
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
			pstmt = connection.prepareStatement(sql);			//预编译
			//绑定字段
			pstmt.setString(1, "wangwu");

			rs = pstmt.executeQuery();	//返回值表示增删改 几条数据
			while(rs.next() == true) {
				//使用getXXX函数获取数据，数据类型是什么就get什么，参数是字段名
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(name+"的号码是"+phone);
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































