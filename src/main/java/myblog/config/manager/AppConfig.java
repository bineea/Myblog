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
//ע�⿪����Spring Data JPA Repostory��֧��
@EnableJpaRepositories(basePackages ={ AppConfig.APP_NAME + ".repo.jpa"}, entityManagerFactoryRef = "entityManager")
//ע�⿪��ע��ʽ�����֧�֣�֪ͨSpring��@Transactionalע����౻����������Χ
/*AdviceMode��������ģʽ��
PROXY(����ģʽ��jdk��̬�����cglib��̬����)
ASPECTJ(����ʱ��ǿģʽ������ʱ���������ǿ�����µ�AOP��)
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
