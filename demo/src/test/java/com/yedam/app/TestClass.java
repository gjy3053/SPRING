package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestClass {
	
	//@Autowired
	//ApplicationContext ctx;
	
	@Autowired
	Restaurant res;
	
	
	@Test
	public void beanTest() {
		//이름이 없는 bean을 가져 올때는 getBean
			//Restaurant res = ctx.getBean(Restaurant.class);
			assertNotNull(res);
	}
}	
