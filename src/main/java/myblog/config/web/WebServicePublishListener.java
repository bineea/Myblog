package myblog.config.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import myblog.manager.AbstractManager;

@WebListener
public class WebServicePublishListener extends AbstractManager implements ServletContextListener {

	//启动listener的时候还没有初始化bean工厂，不可能注入什么东西
	//启动web应用时，系统调用Listener的该方法
	//webService服务与web服务的端口确保不一致
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("-------------Start publish webService-------------");
		
		logger.info("-------------End publish webService-------------");
	}
}
