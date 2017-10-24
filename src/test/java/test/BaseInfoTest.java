package test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alex.pojo.BaseInfo;

public class BaseInfoTest {

	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		BaseInfo baBlogInfo = context.getBean(BaseInfo.class);

		System.out.println(baBlogInfo.getId());

		((ClassPathXmlApplicationContext) context).close();
		
		new BaseInfoTest().haha();

	}

	@Test
	public void haha() {
		System.out.println("haha");
	}
	
	 


}
