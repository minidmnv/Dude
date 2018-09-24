package pl.mn.dude.chat.domain.event;

import java.time.LocalDateTime;

public class LoginEvent {

    public final String username;
    public final LocalDateTime time;

    public LoginEvent(String username, LocalDateTime time) {
        this.username = username;
        this.time = time;
    }
}
