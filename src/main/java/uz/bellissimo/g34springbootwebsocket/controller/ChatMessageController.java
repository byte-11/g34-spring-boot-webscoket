package uz.bellissimo.g34springbootwebsocket.controller;

import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import uz.bellissimo.g34springbootwebsocket.domain.ChatMessage;

@RestController
@Slf4j
public class ChatMessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatMessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/messages")
    @SendTo("/chat")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        //save to db
        chatMessage.setTimestamp(LocalTime.now());
        return chatMessage;
    }

//    @Scheduled(cron = "0/30 * * * * *")
    public void updateMessage() {
        ChatMessage message = new ChatMessage(
                "The time is %s".formatted(LocalTime.now()),
                "John Doe"
        );
        simpMessagingTemplate.convertAndSend(
                "/chat",
                message
        );
        log.info("Message sent to '/chat'");
    }
}
