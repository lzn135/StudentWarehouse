import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class downLoadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("utf-8");
		//获取文件名称
		String filename = req.getParameter("filename");

		ServletContext context = this.getServletContext();
		String realPath = this.getServletContext().getRealPath("/img" + filename);


		FileInputStream fileInputStream = new FileInputStream(realPath);
		String mimeType = context.getMimeType(filename);
		resp.setHeader("content-type", mimeType);
		resp.setHeader("content-disposition", "attachment;filename=" + filename);


		ServletOutputStream sos = resp.getOutputStream();
		byte[] bys = new byte[1024 * 8];
		int len = 0;
		//	while ((len = fis.read(bys)));
		sos.write(bys, 0, len);


	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
