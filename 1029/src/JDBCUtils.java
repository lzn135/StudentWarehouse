import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	public static Connection getConnection() throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();

		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		//将用户名和密码封装到properties()
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "luoye");

		Connection conn = driver.connect(url, info);
		return conn;
	}
}
