package com.example.bloodbank.util;


import com.example.bloodbank.service.EmailService;
import com.example.bloodbank.service.SmsService;
import org.springframework.stereotype.Component;

@Component
public class SmsSender implements MessageSender {

    private SmsService smsService;

    public SmsSender(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void sendConfirmation(Message message) {

    }

    @Override
    public void sendNotification(Message message) {

    }
}
