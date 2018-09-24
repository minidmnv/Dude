package pl.mn.dude.chat.domain.event;

public class LogoutEvent {

    public final String username;

    public LogoutEvent(String username) {
        this.username = username;
    }
}
