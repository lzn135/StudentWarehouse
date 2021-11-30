package org.lanqiao.upload;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.rmi.transport.DGCImpl_Skel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//文件存储位置，处于安全考虑，建议放到WEB-INF下
			String path = this.getServletContext().getRealPath("/WEB-INF/upload");
			//上传临时文件存放目录
			String tempPath = getServletContext().getRealPath("/WEB-INF/temp");
			File file = new File(tempPath);

			if (!file.exists() && !file.isDirectory()) {
				System.out.println("目录或者文件不存在");
				file.mkdir();

			}


			File file1 = new File(path);
			if (!file1.exists() && !file1.isDirectory()) {
				file1.mkdir();

			}
			//使用Apache文件上传组件，上传文件
			//1.创建DiskFileItemFActory工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			//设置工厂缓冲大小
			diskFileItemFactory.setSizeThreshold(1024 * 100);
			//设置临时文件保存目录
			diskFileItemFactory.setRepository(file);

			//2.创建文件上传解析器
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);

			//文件中文乱码
			fileUpload.setHeaderEncoding("UTF-8");


			List<FileItem> items = fileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.isFormField()) {
					//普通输出
					String name = item.getFieldName();
					String Value = item.getString();
					System.out.println(name + "," + Value);
				} else {
					//上传输入
					String filename = item.getName();

					InputStream is = item.getInputStream();
					int len = 0;
					byte[] bys = new byte[1024];
					System.out.println(path + "," + filename);

					FileInputStream fos = new FileInputStream(path + "//" + filename);

					while ((len = is.read(bys)) != -1) {


					}

				}


			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}


	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
