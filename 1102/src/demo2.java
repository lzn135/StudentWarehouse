import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class demo2 {


	@WebServlet("/demo2")
	public class Demo2Servlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//3.获取Cookie
			Cookie[] cookies = req.getCookies();
			//4.遍历Cookies，获取数据
			if (cookies != null) {
				for (Cookie c : cookies) {
					String name = c.getName();
					String value = c.getValue();
					System.out.println(name + ":" + value);
				}
			}
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}

}
