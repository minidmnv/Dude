package pl.mn.dude.chat;

import java.time.LocalDateTime;

public class Message {

    public final Participant sender;
    public final Addressee addressee;
    public final String message;
    public final LocalDateTime time;

    public Message() {
        sender = null;
        message = null;
        time = null;
        addressee = null;
    }
}
