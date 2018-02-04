package myblog.web.comment;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@MainBean(beanName = "mainbean")
public class Main {  
  
    public static void main(String[] args) {  
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);  
  
        String[] beannames = context.getBeanNamesForType(Main.class);  
  
        //当加上@AliasFor时, 输出"mainbean"  
        //当去掉@AliasFor注解后, 输出"main"  
        System.out.println("****************************"+beannames[0]);  
  
        context.close();  
    }  
}  
  
@Target({ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
@Configuration
@interface MainBean {  
	
    @AliasFor(annotation = Component.class, attribute = "value")  
    String beanName() default "";  
} 