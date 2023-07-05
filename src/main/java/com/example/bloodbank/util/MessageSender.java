package com.example.bloodbank.util;

import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    void sendConfirmation(Message message);
    void sendNotification(Message message);
}
