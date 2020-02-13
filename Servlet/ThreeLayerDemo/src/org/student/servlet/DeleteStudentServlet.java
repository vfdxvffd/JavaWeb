package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentService;

public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("sid"));
		
		StudentService studentService = new StudentService();
		//设置响应编码,必须在out创建之前就设置响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		if(studentService.deleteStudent(id)) {	//删除成功
			//out.write("删除成功！");
			response.sendRedirect("QueryAllStudentsServlet");	//删除之后重新查询结果并显示在index.jsp上
		}else {
			out.write("删除失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
