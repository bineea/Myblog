package myblog.config.manager;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//注解开启对Spring Data JPA Repostory的支持
@EnableJpaRepositories(basePackages ={ AppConfig.APP_NAME + ".repo.jpa"}, entityManagerFactoryRef = "entityManager")
//注解开启注解式事务的支持，通知Spring，@Transactional注解的类被事务的切面包围
/*AdviceMode共有两种模式：
PROXY(代理模式，jdk动态代理和cglib动态代理)
ASPECTJ(编译时增强模式，编译时对类进行增强生成新的AOP类)
*/
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, proxyTargetClass = true)
@ComponentScan(basePackages = {AppConfig.APP_NAME + ".manager"})
public class AppConfig 
{
	public static final String APP_NAME = "myblog";
	
	@Bean
	public PropertiesFactoryBean initProperties()
	{
		PropertiesFactoryBean propertiesFactory = new PropertiesFactoryBean();
		Resource[] fileResource = {
				new FileSystemResource(System.getProperty("user.dir")+"\\src\\main\\resources\\config\\hibernate-database.properties")
//				new FileSystemResource("config/log4j.properties")
		};
		propertiesFactory.setLocations(fileResource);
		propertiesFactory.setFileEncoding("utfe-8");
		return propertiesFactory;
	}
	
}
