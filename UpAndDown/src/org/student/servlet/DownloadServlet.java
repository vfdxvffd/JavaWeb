package org.student.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 获取需要下载的文件名
		String filename = request.getParameter("filename");

		// 下载文件需要设置响应消息头
		response.addHeader("contentType", "application/octet-stream"); // MIME类型：二进制文件，任意格式的文件都行
		// 根据不同的浏览器，进行不同的处理
		if (request.getHeader("User-Agent").toLowerCase().contains("firefox")) { // 火狐浏览器
			// 处理火狐乱码
			response.addHeader("content-Disposition", "attachment;filename==?UTF-8?B?"
					+ new String(Base64.encodeBase64(filename.getBytes("UTF-8"))) + "?=");
		} else { // Edge，其他浏览器以后再说
			// 处理Edge下载乱码
			response.addHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		}

		// Servlet通过文件的地址，将文件转为输入流，读到Servlet中
		InputStream is = this.getServletContext().getResourceAsStream("/" + filename);
		ServletOutputStream os = response.getOutputStream();

		byte[] buf = new byte[10];
		int len = -1;
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		os.close();
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
