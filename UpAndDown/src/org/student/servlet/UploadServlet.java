package org.student.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 上传
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) { // 判断前台form是否有multipart这一属性
			// FileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 设置上传文件时用到的临时文件的大小 DiskFileItemFactory
			factory.setSizeThreshold(1024 * 10); // 设置临时的缓冲文件
			factory.setRepository(new File("/home/zhangqi/桌面/uploda/temp")); // 设置临时文件的位置

			// 控制上传单个文件的大小20Kb ServletFileUpload
			upload.setSizeMax(1024 * 20); // 单位是字节

			try {
				// 通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前台传递的sid、sname、spicture此时就保存在了items中）
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next(); // 字段
					String fieldName = item.getFieldName(); // 字段名，即表单信息的name值
					int sid = -1;
					String sname = null;

					// 判断前台字段是普通form表单字段（sid、sname，还是文件字段）
					if (item.isFormField()) {
						if (fieldName.equals("sid")) { // 根据name属性判断item是sid还是sname，或者spricure
							sid = Integer.parseInt(item.getString("UTF-8"));
						} else if (fieldName.equals("sname")) {
							sname = item.getString("UTF-8");
						} else {
							System.out.println("其他字段");
						}
					} else { // spicture
						// 文件 上传
						// 文件名 getName获取文件名
						String fileName = item.getName();
						// 获取文件内容
						// String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "/home/zhangqi/桌面/upload";
						File file = new File(path, fileName);

						item.write(file);
						System.out.println(fileName + "成功！" + path);						
						return;
					}
				}
			} catch (FileUploadBase.SizeLimitExceededException e) {
				System.out.println("文件过大");
				e.printStackTrace();
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
