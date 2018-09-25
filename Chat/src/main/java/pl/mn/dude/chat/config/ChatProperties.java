package pl.mn.dude.chat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chat")
public class ChatProperties {

    public Destinations destinations;

    static class Destinations {
        public String login;
        public String logout;
    }
}
