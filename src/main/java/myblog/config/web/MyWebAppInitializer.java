package myblog.config.web;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.cxf.transport.servlet.CXFServlet;
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
		servletContext.setInitParameter("debug", "true");
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
		registerCxfServlet(servletContext);
		registerCkfinderServlet(servletContext);
	}
	
	public void registerCkfinderServlet(ServletContext servletContext) {
		String servletName = "ckfinderServlet";
		Assert.hasLength(servletName, "getServletName() must not return empty or null");
		//ckfinder自定义servlet
		ConnectorServlet ckfinderServlet = new ConnectorServlet();
		ServletRegistration.Dynamic ckfinderRegistration = servletContext.addServlet(servletName, ckfinderServlet);
		Assert.notNull(ckfinderRegistration,
				"Failed to register servlet with name '" + servletName + "'." +
				"Check if there is another servlet registered under the same name.");

		ckfinderRegistration.addMapping(getCkfinderServletMappings());
		ckfinderRegistration.setAsyncSupported(isAsyncSupported());
		//ckfinder的jar包代码中xml文件对应参数名称已写死为“XMLConfig”，且路径必须为绝对路径
		ckfinderRegistration.setInitParameter("XMLConfig", "/WEB-INF/classes/config/ckfinder.xml");
		ckfinderRegistration.setInitParameter("debug", "true");
		ckfinderRegistration.setLoadOnStartup(3);
	}
	
	public String[] getCkfinderServletMappings() {
		//指定需要由ckfinderServlet映射的路径（同理/app/*）
		return new String[] { "/assets/plugins/ckfinder/core/connector/java/connector.java" };
	}
	
	public void registerCxfServlet(ServletContext servletContext) {
		String servletName = "cxfServlet";
		Assert.hasLength(servletName, "getServletName() must not return empty or null");
		CXFServlet cxfServlet = new CXFServlet();
		ServletRegistration.Dynamic cxfRegistration = servletContext.addServlet(servletName, cxfServlet);
		Assert.notNull(cxfRegistration,
				"Failed to register servlet with name '" + servletName + "'." +
				"Check if there is another servlet registered under the same name.");

		cxfRegistration.addMapping(getCxfServletMappings());
		//ckf的jar包代码中xml文件对应参数名称已写死为“config-location”
		//如果未查找到“config-location”对应参数，则直接查找文件“/WEB-INF/cxf-servlet.xml”
		cxfRegistration.setInitParameter("config-location", "classpath:config/webservice.xml");
		cxfRegistration.setInitParameter("debug", "true");
		cxfRegistration.setLoadOnStartup(2);
	}
	
	public String[] getCxfServletMappings() {
		//指定需要由cxfServlet映射的路径（同理/app/*）
		return new String[] {"/webservice/*"};
	}
}
