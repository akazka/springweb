package com.spring.user;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	@Test
	public void userTest() {
		//1.Spring 컨테이너를 구동한다
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 컨테이너로부터 UserServiceImpl객체를 Lookup 한다.
		UserService userService=(UserService) container.getBean("userService");
		
		//3.로그인 기능 테스트
		UserVO vo=new UserVO();
		vo.setId("test");
		vo.setPassword("test1234");
		
		UserVO user=userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
		//4.Spring  컨테이너를 종료한다.
		container.close();
	}

}
