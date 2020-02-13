package org.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Address;
import org.student.entity.Student;


public class ELInitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Address address = new Address("xa","bj");
		Student student = new Student(1,"zs",address);
		Student student2 = new Student(2,"ls",address);
		Student student3 = new Student(3,"ww",address);
		//将student放入request域
		request.setAttribute("student", student);
		
		//特殊字符
		request.setAttribute("my-name", "my-name");
		request.setAttribute("name", "my-name");
		
		//数组
		String[] hobbies = {"bashketball", "football", "pingpang"};
		request.setAttribute("hobbies", hobbies);
		
		//map的操作
		Map<String, Object> map = new HashMap<>();
		map.put("CN","中国");
		map.put("US","美国");
		request.setAttribute("map",map);
		
		
		//演示sessionScope
		request.getSession().setAttribute("sessionKey", "sessionValue");
		
		
		String[] names = {"aa","bb","cc"};
		request.setAttribute("names", names);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student2);
		students.add(student3);
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("jstl2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
