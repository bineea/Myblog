package myblog.config.manager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

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
	
	@Bean(name = "databaseProperties")
	public PropertiesFactoryBean loadDatabaseProperties()
	{
		PropertiesFactoryBean propertiesFactory = new PropertiesFactoryBean();
		propertiesFactory.setLocation(new ClassPathResource("config/hibernate-database.properties"));
		propertiesFactory.setFileEncoding("utf-8");
		return propertiesFactory;
	}
	
	@Bean(name = "log4jProperties")
	public PropertiesFactoryBean loadLog4jProperties()
	{
		PropertiesFactoryBean propertiesFactory = new PropertiesFactoryBean();
		propertiesFactory.setLocation(new ClassPathResource("config/log4j.properties"));
		propertiesFactory.setFileEncoding("utf-8");
		return propertiesFactory;
	}
	
	@Value("#{databaseProperties.driverClassName}")
	private String driverClassName;
	@Value("#{databaseProperties.url}")
	private String jdbcUrl;
	@Value("#{databaseProperties.username}")
	private String username;
	@Value("#{databaseProperties.password}")
	private String password;
	@Value("#{databaseProperties.dialect}")
	private String dialect;
	@Value("#{databaseProperties.validationQuery}")
	private String validationQuery;
	
	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource initDataSource()
	{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		//��ʼ��������
		dataSource.setInitialSize(5);
		//��С����������
		dataSource.setMinIdle(1);
		//���������
		dataSource.setMaxActive(100);
		//������ӵȴ�ʱ��
		dataSource.setMaxWait(60000);
		//SQL��ѯ,������֤�����ӳ�ȡ��������,�ڽ����ӷ��ظ�������֮ǰ.���ָ��,���ѯ������һ��SQL SELECT���ұ��뷵������һ�м�¼ 
		dataSource.setValidationQuery(validationQuery);
		//�Ƿ��ڴ����ӳ���ȡ������ǰ���м���,�������ʧ��,������ӳ���ȥ�����Ӳ�����ȡ����һ����������Ϊtrue��validationQuery������������Ϊ�ǿ��ַ���
		dataSource.setTestOnBorrow(false);
		//�Ƿ��ڹ黹������ǰ���м��飻������Ϊtrue��validationQuery������������Ϊ�ǿ��ַ���
		dataSource.setTestOnReturn(false);
		//�����Ƿ񱻿������ӻ�����(�����)���м���.������ʧ��,�����ӽ����ӳ���ȥ����������Ϊtrue��validationQuery������������Ϊ�ǿ��ַ���
		dataSource.setTestWhileIdle(true);
		// ��PSCache������ָ��ÿ��������PSCache�Ĵ�С
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		return dataSource;
	}
}
