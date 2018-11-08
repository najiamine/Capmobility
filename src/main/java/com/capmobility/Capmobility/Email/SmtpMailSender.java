package com.capmobility.Capmobility.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String to, String subject, String body) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true signife multipart de message
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true signife html continue more fonctionalités comme l'ajout d'attachement
		
		javaMailSender.send(message);
	}

}
