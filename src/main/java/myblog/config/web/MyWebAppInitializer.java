package myblog.config.web;

import javax.servlet.ServletContext;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import myblog.config.manager.AppConfig;

//配置web.xml
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	//指定需要由DispatcherServlet映射的路径，如果是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/app/*" };
	}
	
	@Override
	public void registerContextLoaderListener(ServletContext servletContext) {
		servletContext.setInitParameter("logbackConfigLocation", "classpath:config/logback.xml");
		servletContext.addListener(LogbackConfigListener.class);
		super.registerContextLoaderListener(servletContext);
	}
	
}
