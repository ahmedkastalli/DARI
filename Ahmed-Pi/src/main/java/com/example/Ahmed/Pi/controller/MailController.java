package com.example.Ahmed.Pi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ahmed.Pi.domain.Agent;
import com.example.Ahmed.Pi.services.MailService;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("mail")
public class MailController {

	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private Agent agent ;

	/**
	 * 
	 * @return
	 */
//	@RequestMapping("send-mail")
	@GetMapping("send-mail")
	public String send(@RequestParam String subject,@RequestParam String text) {

		/*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
		agent.setFirstName("ahmed");
		agent.setLastName("kastalli");
		agent.setEmailAddress("ahmed.kastalli@esprit.tn	"); //Receiver's email address

		//subject="subject test";
		//text="what is up ma dude lee";
		
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			mailService.sendEmail(agent,subject,text);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws javax.mail.MessagingException 
	 */
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException, javax.mail.MessagingException {

		/*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
		agent.setFirstName("ahmed");
		agent.setLastName("kastalli");
		agent.setEmailAddress("ahmed.kastalli@esprit.tn"); //Receiver's email address

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
		 * that contains a attachment.
		 */
		try {
			mailService.sendEmailWithAttachment(agent);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
