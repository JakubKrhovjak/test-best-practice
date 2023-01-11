package com.example.testbestpractice.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */

public class ItemService {

    @Autowired
    private JavaMailSender emailSender;

    public String doSomeStaff() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@test.com");
        message.setTo("jakub.krhovjak@protonmail.com");
        message.setSubject("subject");
        message.setText("email from item service");
        emailSender.send(message);
        return "done";
    }

}
