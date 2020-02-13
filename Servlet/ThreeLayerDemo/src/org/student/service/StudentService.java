package org.student.service;

import java.util.List;

import org.student.dao.StudentDao;
import org.student.entity.Student;

//业务逻辑层：逻辑性的增删改查
public class StudentService {

	private StudentDao dao = new StudentDao();
	
	/**
	 * 增加学生
	 * @param student	新增的学生信息
	 * @return			成功与否
	 */
	public boolean addStudent(Student student) {
		
		if(dao.isExist(student.getId())) {	//已经存在
			System.out.println("此人已存在");
			return false;
		}else {
			return dao.addStudent(student);
		}
	}

	/**
	 * 根据学号删除学生信息
	 * @param id		待删学生信息
	 * @return			成功与否
	 */
	public boolean deleteStudent(int id) {
		
		if(dao.isExist(id)) {
			return dao.deleteStudent(id);
		}else {
			System.out.println("此人不存在！");
			return false;
		}
	}
	
	/**
	 * 更改学生信息
	 * @param id		待修改学生学号
	 * @param student	学生新信息
	 * @return			成功与否
	 */
	public boolean updateStudent(int id, Student student) {
		
		if(dao.isExist(id)) {
			return dao.updateStudent(id, student);
		}else {
			System.out.println("此人不存在！");
			return false;
		}
	}
	
	/**
	 * 根据学号查询某个学生信息
	 * @param id		待查找学生的学号
	 * @return			学生信息
	 */
	public Student queryStudentById(int id) {
		return dao.queryStudentById(id);
	}
	
	/**
	 * 查询所有学生的信息
	 * @return			返回一个装有所有学生信息的List集合
	 */
	public List<Student> queryAllStudents() {
		return dao.queryAllStudents();
	}

}
