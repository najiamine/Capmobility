package com.capmobility.Capmobility.Service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capmobility.Capmobility.Email.SmtpMailSender;

@RestController
public class EmailService {
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	
	@RequestMapping(value="/send-mail")
	public String sendMail() throws MessagingException {
		smtpMailSender.send("abdou.bouchra93@gmail.com", "test mailing CapMobility", "Body");
		return "Message Envoyé";
	}

}
