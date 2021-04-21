package com.example.inn.sendingmail.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail,String body, String subject) {
	
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("sayantani572@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.print("Mail send");
		}
   public void sendEmailwithAttachment(String toEmail,String body, String subject, String attachment ) throws MessagingException {
	   MimeMessage mimeMessage =mailSender.createMimeMessage();
	   MimeMessageHelper mimeMessgeHelper = new MimeMessageHelper(mimeMessage,true);
	   mimeMessgeHelper.setFrom("sayantani572@gmail.com");
	   mimeMessgeHelper.setTo(toEmail);
	   mimeMessgeHelper.setText(body);
	   mimeMessgeHelper.setSubject(subject);
	   
	   FileSystemResource fileSystem =new FileSystemResource(new File(attachment)); 
	   mimeMessgeHelper.addAttachment(fileSystem.getFilename(), fileSystem);
	   mailSender.send(mimeMessage);
	   System.out.println("mail Send");
   }
}
