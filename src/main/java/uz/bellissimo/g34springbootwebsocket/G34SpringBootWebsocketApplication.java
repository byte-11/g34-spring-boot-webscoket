package uz.bellissimo.g34springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableScheduling
@EnableWebSocketMessageBroker
public class G34SpringBootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(G34SpringBootWebsocketApplication.class, args);
    }

}
