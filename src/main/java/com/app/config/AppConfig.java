package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.app")
public class AppConfig {
	@Bean
	public JavaMailSenderImpl jms() {
		JavaMailSenderImpl m=new JavaMailSenderImpl();
		m.setHost("smtp.gmail.com");
		m.setPort(587);
		m.setUsername("sathyatech9898@gmail.com");
		m.setPassword("India123.");
		m.setJavaMailProperties(props());
		return m;
	}
	@Bean	
	public Properties props() {
		Properties p=new Properties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		return p;
	}
	
	
}
