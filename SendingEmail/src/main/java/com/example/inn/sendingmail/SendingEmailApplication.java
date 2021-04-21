package com.example.inn.sendingmail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.inn.sendingmail.service.EmailSenderService;

@SpringBootApplication
public class SendingEmailApplication {
	
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SendingEmailApplication.class, args);
	}
//		@EventListener(ApplicationReadyEvent.class)
//		public void triggerMail() {
//		
//			service.sendSimpleEmail("sayantaniit1997@gmail.com","Hey, Joker I'm sending you mail to check whether api is working or not ","To check api");
//		}
	
		@EventListener(ApplicationReadyEvent.class)
		public void triggerMail() throws MessagingException {
		
			service.sendEmailwithAttachment("sayantaniit1997@gmail.com", "Hello!! Sayantani", "For testing", "C:\\Users\\sayantani\\OneDrive\\Pictures\\Saved Pictures\\imp things\\WhatsApp Images\\WhatsApp Images\\IMG_20171228_100233.jpg");
		}
	}


