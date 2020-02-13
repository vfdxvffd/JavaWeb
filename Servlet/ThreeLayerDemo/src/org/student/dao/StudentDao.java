package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

//数据访问层：原子性的增删改查
public class StudentDao {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/exercise?useSSL=false&&serverTimezone=UTC";
	private static final String NAME = "root"; // 用户名，一般为root
	private static final String PASSWORD = "123456"; // 数据库的密码
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/**
	 * 根据学号查询学生
	 * @param id	学号
	 * @return		学生对象
	 */
	public Student queryStudentById(int id) {
		
		Student student = null;		//返回值		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "select * from student where id = ?;";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int sid = rs.getInt("id");
				String sname = rs.getString("name");
				int sage = rs.getInt("age");
				String saddress = rs.getString("address");
				student = new Student(sid, sname, sage, saddress);
			}
			return student;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 根据学号判断此人是否已经存在
	 * @param id	学号
	 * @return		true：存在	false：不存在
	 */
	public boolean isExist(int id) {	
		return queryStudentById(id) == null?false:true;
	}
	
	/**
	 * 增加学生
	 * @param student	新增的学生对象
	 * @return		成功与否
	 */
	public boolean addStudent(Student student) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "insert into student values(?,?,?,?);";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getAddress());
			count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 根据学号删除学生信息
	 * @param id	学号
	 * @return		成功与否
	 */
	public boolean deleteStudent(int id) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "delete from student where id = ?;";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
			return count == 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 根据学号修改信息
	 * @param id		要修改学生的学号
	 * @param student	新信息
	 * @return			成功与否
	 */
	public boolean updateStudent(int id, Student student) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "update student set name = ?, age = ?, address = ? where id = ?;";
			pstmt = connection.prepareStatement(sql);
			//修改后的内容
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getAddress());
			//修改的那个人的学号
			pstmt.setInt(4, id);	
			count = pstmt.executeUpdate();
			return count == 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 查询全部学生的信息
	 * @return		返回一个ArrayList集合，里面装所有学生信息
	 */
	public List<Student> queryAllStudents() {
		
		List<Student> students = new ArrayList<Student>();//返回值		
		Student student = null;		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,NAME,PASSWORD);
			String sql = "select * from student;";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt("id");
				String sname = rs.getString("name");
				int sage = rs.getInt("age");
				String saddress = rs.getString("address");
				student = new Student(sid, sname, sage, saddress);
				students.add(student);
			}
			return students;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	



}












