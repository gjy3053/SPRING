package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {	
	private String name;
	private Integer age;
	//java.util.Date -> 포맷이 우리나라 방식과 많이 다름 yyyy-MM-dd
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//DateTimeFormat -> 입력받을 때 형식 정하는거, 출력과는 상관없다
	private Date today;
	
	private MultipartFile pic;
	
}
