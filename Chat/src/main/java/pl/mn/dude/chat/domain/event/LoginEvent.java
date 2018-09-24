package pl.mn.dude.chat.domain.event;

import pl.mn.dude.chat.domain.model.Participant;

import java.time.LocalDateTime;

public class LoginEvent {

    public final Participant participant;
    public final LocalDateTime time;

    public LoginEvent() {
        participant = null;
        time = null;
    }
}
