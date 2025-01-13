package com.notification.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * NotificationController handles WebSocket messages from clients and broadcasts responses.
 * <p>
 * - Maps client messages to specific endpoints.
 * - Sends responses to subscribed clients via a message broker.
 */
@Controller
public class NotificationController {

    /**
     * Handles messages sent to the "/sendMessage" destination.
     *
     * @param message The message received from the client.
     * @return The message to be broadcast to all subscribers of the "/topic/notifications" destination.
     * <p>
     * - `@MessageMapping("/sendMessage")`: Maps messages sent to "/app/sendMessage" (prefixed by "/app" from WebSocketConfig) to this method.
     * - `@SendTo("/topic/notifications")`: Specifies that the return value of this method will be sent to all clients subscribed to "/topic/notifications".
     * - The `message` is printed to the server's console for logging/debugging purposes.
     */
    @MessageMapping("/sendMessage")
    @SendTo("/topic/notifications")
    public String sendMessages(String message) {
        System.out.println("Message:" + message);
        return message;
    }

}
