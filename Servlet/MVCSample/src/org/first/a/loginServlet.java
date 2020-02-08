package org.first.a;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.first.entity.userBean;

//控制器层：用于接受View层的请求，并分发给Model处理
public class loginServlet extends HttpServlet {
	//defalut
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//处理登陆
		request.setCharacterEncoding("UTF-8");
		
		loginDao dao = new loginDao();
		userBean user = new userBean(request.getParameter("uname"), request.getParameter("upwd"));
		
		//调用模型层登陆功能
		int result = dao.login(user);
		if(result == 1) {
			//登陆成功！
			response.sendRedirect("welcome.jsp");
		}else if(result == 0){
			//登陆失败！密码或用户名错误
			response.sendRedirect("error.jsp");
		}else {
			//系统异常！
			response.sendRedirect("exception.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
