import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class demo1 {
	@WebServlet("/demo1")
	public class Demo1 extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
			//1.创建Cookie
			Cookie cookie = new Cookie("msg", "hello");
			//2.发送Cookis
			resp.addCookie(cookie);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}

}
