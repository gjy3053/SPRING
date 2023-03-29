package com.yedam.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.tx.service.Cats;
import com.yedam.spring.tx.service.CccService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class TxServiceImplTest {
	
	@Autowired
	CccService cccService;
	
	@Autowired
	Cats myCat;
	
	@Test
	public void txTest() {
		cccService.insert();
	}
	
	@Test
	public void aopTest() {
		myCat.printInfo();
	}
}
