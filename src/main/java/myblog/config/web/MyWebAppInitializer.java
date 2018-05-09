package myblog.config.web;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.util.Assert;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ckfinder.connector.ConnectorServlet;

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
	
	//配置log
	@Override
	public void registerContextLoaderListener(ServletContext servletContext) {
		servletContext.setInitParameter("logbackConfigLocation", "classpath:config/logback.xml");
		servletContext.addListener(LogbackConfigListener.class);
		super.registerContextLoaderListener(servletContext);
	}
	
	//在AbstractAnnotationConfigDispatcherServletInitializer将DispatcherServlet注册到Servlet容器中之后，就会调用customizeRegistration()，并将Servlet注册后得到的Registration.Dynamic传递进来。通过重载customizeRegistration()方法，我们可以对DispatcherServlet进行额外的配置。
	//重写customizeRegistration方法，添加额外配置
	@Override
	public void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		MultipartConfigElement multipartConfig = new MultipartConfigElement("", 1000000000L, -1, 0);
		registration.setMultipartConfig(multipartConfig);
	}
	
	//重写onStartup方法，添加额外servlet
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		registerCkfinderServlet(servletContext);
	}
	
	public void registerCkfinderServlet(ServletContext servletContext) {
		String servletName = "connectorServlet";
		Assert.hasLength(servletName, "getServletName() must not return empty or null");
		ConnectorServlet ckfinderServlet = new ConnectorServlet();
		ServletRegistration.Dynamic ckfinderRegistration = servletContext.addServlet(servletName, ckfinderServlet);
		Assert.notNull(ckfinderRegistration,
				"Failed to register servlet with name '" + servletName + "'." +
				"Check if there is another servlet registered under the same name.");

		ckfinderRegistration.addMapping(getCkfinderServletMappings());
		ckfinderRegistration.setAsyncSupported(isAsyncSupported());
		ckfinderRegistration.setInitParameter("XMLConfig", "/WEB-INF/ckfinder-config.xml");
		ckfinderRegistration.setInitParameter("debug", "false");
	}
	
	public String[] getCkfinderServletMappings() {
		return new String[] { "/assets/plugins/ckfinder/core/connector/java/connector.java" };
	}
	
}
