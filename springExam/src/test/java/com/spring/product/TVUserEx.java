package com.spring.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserEx {

	public static void main(String[] args) {
		//1.Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
					new GenericXmlApplicationContext("applicationContext.xml");
		//2.Spring 컨테이너로부터 필요한 객체를 요청(Lookyp)한다.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeDown();
		tv.volumeUp();
		
		//3.컨테이너를 종료한다.
		factory.close();
	}
}
