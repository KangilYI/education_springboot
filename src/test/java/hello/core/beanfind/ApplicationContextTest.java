package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class ApplicationContextTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


	/**
	 * 실행하면 스프링에 등록된 모든 Bean 정보를 출력할 수 있다.
	 * `getBeanDefinitionNames()` 스프링에 등록된 모든 Bean 이름을 조회한다.
	 * `getBean()` Bean 이름으로 Bean객체(instance)를 조회한다.
	 */
	@Test
	@DisplayName("Bean 출력하기")
	void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();

		for(String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + ", Object = "+ bean);
		}
	}

	/**
	 * 스프링이 내부에서 사용하는 Bean은 제외하고, 내가 드록한 빈만 출력
	 * 스프링이 내부에서 사용하는 Bean은 `getRole()`로 구분할 수 있다.
	 */
	@Test
	@DisplayName("ApplictionBean 출력하기")
	void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();

		for(String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

			//Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
			//Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
			//if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
			if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + ", Object = "+ bean);
			}
		}
	}
}
