package org.lanqiao.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Demo1Listener implements ServletContextListener {
	/*
		监听servletcontext对象的初始化，服务器启动时创建servletContext

	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		/*
			//加载配置文件
			//获取ServletContetxt对象
		 */
		ServletContext servletContext = servletContextEvent.getServletContext();


	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
