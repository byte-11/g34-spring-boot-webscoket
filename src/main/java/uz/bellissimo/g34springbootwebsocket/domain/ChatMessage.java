package uz.bellissimo.g34springbootwebsocket.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {
    private Long id = new Random().nextLong(1);
    private String from;
    private String text;
    private LocalTime timestamp = LocalTime.now();

    public ChatMessage(String text, String from) {
        this.text = text;
        this.from = from;
    }
}
