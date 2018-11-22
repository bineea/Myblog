package myblog.config.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import myblog.manager.AbstractManager;
import myblog.manager.service.MyFirstWebserviceImpl;

@WebListener
public class WebServicePublishListener extends AbstractManager implements ServletContextListener {

	//启动web应用时，系统调用Listener的该方法
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("-------------Start publish webService-------------");
		Endpoint.publish("http://127.0.0.1:8080/myblog/webservice/myFirst", new MyFirstWebserviceImpl());
		logger.info("-------------End publish webService-------------");
	}
}
