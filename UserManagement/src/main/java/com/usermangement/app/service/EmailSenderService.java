package com.usermangement.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 

@Service 
public class EmailSenderService {

	@Autowired
    private JavaMailSender javamailsender;
	
	public void sendEmail(String toMail, String subject,String body)
	{
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setFrom("arundhole3218@gmail.com");
		sm.setTo(toMail);
		sm.setText(body);
		sm.setSubject(subject);
		
		javamailsender.send(sm);
		
		System.out.println("Mail sent succesfully....");
	}
}
