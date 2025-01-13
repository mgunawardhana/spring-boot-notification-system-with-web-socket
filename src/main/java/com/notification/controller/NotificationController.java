package com.notification.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    //
    //app/sendMessage
    @MessageMapping("/sendMessage")
    @SendTo("/topic/notifications")
    public String sendMessages(String message){
        System.out.println("Message:"+message);
        return message;
    }

}
