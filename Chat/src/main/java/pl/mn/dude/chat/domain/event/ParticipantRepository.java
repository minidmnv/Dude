package pl.mn.dude.chat.domain.event;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParticipantRepository {

    private Map<String, LoginEvent> activeSessions = new ConcurrentHashMap<>();

    public void add(String sessionId, LoginEvent event) {
        activeSessions.put(sessionId, event);
    }

    public Optional<LoginEvent> getParticipant(String sessionId) {
        return Optional.ofNullable(activeSessions.get(sessionId));
    }

    public void removeParticipant(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public Map<String, LoginEvent> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<String, LoginEvent> sessions) {
        this.activeSessions = sessions;
    }

}
