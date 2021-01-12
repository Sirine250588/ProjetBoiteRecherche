package com.example.recherche.Controller;

import com.example.recherche.model.Mail;
import com.example.recherche.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class MailController {
    @CrossOrigin("*")
    @RestController
    public class MailRestController {
        @Autowired
        private EmailService emailService;
        @RequestMapping(value="/sendMail",method= RequestMethod.POST)
        public String sendMail(){
            System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");
            Mail mail = new Mail();
            mail.setFrom("cyrine.benabdessalem@gmail.com");
            mail.setTo("cyrine.benabdessalem@gmail.com");
            mail.setSubject("Sending Simple Email with JavaMailSender Example");
            mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");
            emailService.sendSimpleMessage(mail);
            return "ok";
        }
    }
}
