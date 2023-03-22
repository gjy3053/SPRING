package com.yedam.app.spring;

import org.springframework.stereotype.Component;

@Component("tv") //이름을 생략 할때도 있고 붙일 때도 있다
public class SamsungTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링 방식으로 SamsungTV 켬");

	}

}
