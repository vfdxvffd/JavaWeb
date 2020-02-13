package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;

public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("sid"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(id, name, age, address);
		
		StudentService studentService = new StudentService();
		//设置响应编码,必须在out创建之前就设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		if(!studentService.addStudent(student)) {	//增加失败,则在request中放入一条数据
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "addSuccess");
		}
		request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
