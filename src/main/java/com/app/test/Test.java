package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.app.config.AppConfig;
import com.app.seder.AppMailSeder;
//ctrl+sift+O
public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=
				 new AnnotationConfigApplicationContext(AppConfig.class);
		AppMailSeder sender=ac.getBean("appMailSeder",AppMailSeder.class);
		FileSystemResource file=new FileSystemResource(
				 "d:\\abcd.png");
		boolean flag=sender.sendEmail("abcd@gmail.com", "Hello", "hi", file);
		System.out.println(flag);
		
	}
}
