package myblog.config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/app/*" };
	}
}
