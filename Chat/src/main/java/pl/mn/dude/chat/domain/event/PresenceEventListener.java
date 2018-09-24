package pl.mn.dude.chat.domain.event;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.time.LocalDateTime;
import java.util.Optional;

public class PresenceEventListener {

    private final ParticipantRepository participantRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private String loginDestination;
    private String logoutDestination;

    public PresenceEventListener(ParticipantRepository participantRepository, SimpMessagingTemplate messagingTemplate) {
        this.participantRepository = participantRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        LoginEvent loginEvent = new LoginEvent(headers.getUser().getName(), LocalDateTime.now());

        messagingTemplate.convertAndSend(loginDestination, loginEvent);

        participantRepository.add(headers.getSessionId(), loginEvent);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        participantRepository.getParticipant(event.getSessionId())
                .ifPresent(loginEvent -> {
                    messagingTemplate.convertAndSend(logoutDestination, new LogoutEvent(loginEvent.username));
                    participantRepository.removeParticipant(event.getSessionId());
                });
    }

    public void setLoginDestination(String loginDestination) {
        this.loginDestination = loginDestination;
    }

    public void setLogoutDestination(String logoutDestination) {
        this.logoutDestination = logoutDestination;
    }
}
