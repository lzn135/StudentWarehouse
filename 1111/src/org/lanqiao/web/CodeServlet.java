package org.lanqiao.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/imgcode")
public class CodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int width = 100;
		int heigth = 50;
		//1.创建图片对象
		BufferedImage image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);

		//2.美化图片
		//填充背景色
		//获取画笔对象
		Graphics g = image.getGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, width, heigth);

		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, heigth - 1);

		//填充验证码
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		Random r = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 4; i++) {
			int index = r.nextInt(str.length());//随机索引

			char ch = str.charAt(index);//随机字符

			sb.append(ch);

			//填验证码
			g.drawString(ch + "", width / 5 * i, 25);
		}

		String code = sb.toString();

		//将code验证码存入session
		req.getSession().setAttribute("code", code);

		//画干扰线
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			int x1 = r.nextInt(width);
			int x2 = r.nextInt(width);

			int y1 = r.nextInt(heigth);
			int y2 = r.nextInt(heigth);

			g.drawLine(x1, y1, x2, y2);
		}


		//3.将图片输出到页面
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}