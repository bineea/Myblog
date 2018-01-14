package myblog.config.manager;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
	
	
}
