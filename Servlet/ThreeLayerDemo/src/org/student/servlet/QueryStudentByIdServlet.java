package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;

public class QueryStudentByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("sid"));
		
		StudentService studentService = new StudentService();
		//设置响应编码,必须在out创建之前就设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Student student = studentService.queryStudentById(id);
		//System.out.println(student);
		//查到此人后，通过一个前台页面:studentInfo.jsp显示此人信息
		request.setAttribute("stuInfo", student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
