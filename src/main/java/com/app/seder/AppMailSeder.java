package com.app.seder;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
//ctrl+shift+O
@Component
public class AppMailSeder {
	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(
			String to,
			String subject,
			String text,
			FileSystemResource file) {

		boolean flag=false;
		try {
			//1. create MimeMessage object
			MimeMessage message=sender.createMimeMessage();
			//2. create Helper cls object
			MimeMessageHelper helper=new MimeMessageHelper(
					 message, file!=null?true:false);   
			//3. use helper and set message details
			helper.setTo(to);
			helper.setSubject(subject);;
			helper.setText(text);
			//helper.setCc("");
			//helper.setBcc("");
			helper.setFrom("sathyatech9898@gmail.com");
			if(file!=null) {
				helper.addAttachment(file.getFilename(), file);
			}
			//4. send message
			sender.send(message);
			flag=true;
		}catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}






