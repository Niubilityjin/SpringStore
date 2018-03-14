package Test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.store.bean.User;
import spring.store.mapper.UserMapper;

public class Test1 {
	
	public void testinsert() {
		User user=new User();
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper mapper=ac.getBean("userMapper",UserMapper.class);
		user.setUsername("laojin2");
		user.setPassword("2222");
		user.setPhone("123");
		user.setEmail("2222");
		
		user.setGender(1);
		
		
		mapper.insert(
				user);
		ac.close();
	}
	@Test
	public void testgetUserByUsername() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper mapper=ac.getBean("userMapper",UserMapper.class);
		
		User user=mapper.getUserByUsername("laojin2");
		System.out.println(user);
	}
}
