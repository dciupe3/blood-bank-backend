package com.example.bloodbank.util;

import com.example.bloodbank.service.EmailService;
import com.example.bloodbank.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageSenderFactory {

    private static EmailService emailService;
    private static SmsService smsService;

    @Autowired
    public MessageSenderFactory(EmailService emailService, SmsService smsService){
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public static List<MessageSender> createSenders() {
        List<MessageSender> senders = new ArrayList<>();

        senders.add(new EmailSender(emailService));
        senders.add(new SmsSender(smsService));

        return senders;
    }

}
