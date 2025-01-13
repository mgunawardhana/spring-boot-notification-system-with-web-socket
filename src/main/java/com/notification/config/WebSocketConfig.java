package com.notification.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfig sets up the WebSocket message broker configuration for the application.
 * <p>
 * - Enables WebSocket message handling with a simple broker.
 * - Defines STOMP (Simple Text Oriented Messaging Protocol) endpoints for client connections.
 * - Configures the broker to manage destinations for publishing and subscribing to messages.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker that handles the routing of messages between clients and the server.
     *
     * @param config the MessageBrokerRegistry to configure message broker settings.
     *               <p>
     *               - `enableSimpleBroker("/topic")`: Enables a simple in-memory message broker for destinations prefixed with "/topic".
     *               Clients subscribing to destinations like "/topic/messages" will receive messages sent there.
     *               - `setApplicationDestinationPrefixes("/app")`: Defines a prefix for client-to-server message mappings.
     *               Clients send messages to destinations like "/app/hello", which are routed to message-handling methods on the server.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers STOMP endpoints that clients use to connect to the WebSocket server.
     *
     * @param registry the StompEndpointRegistry to configure STOMP endpoints.
     *                 <p>
     *                 - `addEndpoint("/ws")`: Defines the WebSocket endpoint at "/ws" where clients can connect.
     *                 - `setAllowedOrigins("http://localhost:63342")`: Restricts connections to the specified origin for security.
     *                 - `withSockJS()`: Enables a fallback option using SockJS for clients that don't support WebSocket.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:63342").withSockJS();
    }
}
