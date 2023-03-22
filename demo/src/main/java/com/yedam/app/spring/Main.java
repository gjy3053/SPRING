package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctv
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv = (TV)ctv.getBean("tv");
		tv.on();
		
	}
}
