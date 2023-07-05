package com.example.bloodbank.util;

import com.example.bloodbank.service.EmailService;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender{

    private EmailService emailService;

    public EmailSender(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendConfirmation(Message message) {
        emailService.sendSimpleMessage(message.getEmail(), "Appointment Confirmation", message.getText());
    }

    @Override
    public void sendNotification(Message message) {
        emailService.sendSimpleMessage("Dont forget about your appointment\n" + message.getEmail(), "Appointment Reminder", message.getText());
    }
}
