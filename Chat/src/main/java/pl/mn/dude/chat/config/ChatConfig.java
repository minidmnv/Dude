package pl.mn.dude.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import pl.mn.dude.chat.domain.event.ParticipantRepository;
import pl.mn.dude.chat.domain.event.PresenceEventListener;

@Configuration
@EnableConfigurationProperties(ChatProperties.class)
public class ChatConfig {

    @Autowired
    private ChatProperties properties;

    @Bean
    @Description("Sledzi aktywnosc uzytkownikow")
    public PresenceEventListener presenceEventListener(SimpMessagingTemplate messagingTemplate) {
        PresenceEventListener presenceEventListener = new PresenceEventListener(participantRepository(), messagingTemplate);
        presenceEventListener.setLoginDestination(properties.destinations.login);
        presenceEventListener.setLogoutDestination(properties.destinations.logout);

        return presenceEventListener;
    }

    @Bean
    @Description("Przetrzymuje aktywnych uzytkownikow")
    public ParticipantRepository participantRepository() {
        return new ParticipantRepository();
    }

}
