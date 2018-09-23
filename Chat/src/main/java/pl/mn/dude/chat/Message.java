package pl.mn.dude.chat;

import java.time.LocalDateTime;

public class Message {

    private final User user;
    private final String message;
    private final LocalDateTime time;

    public Message() {
        user = null;
        message = null;
        time = null;
    }
}
