package myblog.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import myblog.config.manager.AppConfig;

//配置spring-servlet.xml
//配置注解驱动mvc 等效于 <mvc:annotation-driven/>
@EnableWebMvc
//注解该类为配置类
@Configuration
//注解需要扫描的包
@ComponentScan(basePackages = AppConfig.APP_NAME + ".web")
public class WebConfig implements WebMvcConfigurer 
{
	//配置视图解析器
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//配置静态资源
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	/*@Autowired
	private AclHandlerInterceptor aclInterceptor;

	*/
	/**
	 * 覆盖父类方法注册拦截器
	 */
	/*
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(aclInterceptor);// 访问控制
	}*/
}
