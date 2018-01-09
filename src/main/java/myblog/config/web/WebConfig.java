package myblog.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import myblog.config.manager.AppConfig;

//����spring-servlet.xml
//����ע������mvc ��Ч�� <mvc:annotation-driven/>
@EnableWebMvc
//ע�����Ϊ������
@Configuration
//ע����Ҫɨ��İ�
@ComponentScan(basePackages = AppConfig.APP_NAME + ".web")
public class WebConfig implements WebMvcConfigurer 
{
	//������ͼ������
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//���þ�̬��Դ
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	/*@Autowired
	private AclHandlerInterceptor aclInterceptor;

	*/
	/**
	 * ���Ǹ��෽��ע��������
	 */
	/*
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(aclInterceptor);// ���ʿ���
	}*/
}
