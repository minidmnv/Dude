package pl.mn.dude.chat.model;

import java.time.LocalDateTime;

public class Message {

    public final Participant sender;
    public final Addressee addressee;
    public final String message;
    public final LocalDateTime time;
    public final LocalDateTime serverTime;

    public Message() {
        sender = null;
        message = null;
        time = null;
        addressee = null;
        serverTime = null;
    }

    private Message(Builder builder) {
        sender = builder.sender;
        addressee = builder.addressee;
        message = builder.message;
        time = builder.time;
        serverTime = builder.serverTime;
    }

    public static final class Builder {
        private Participant sender;
        private Addressee addressee;
        private String message;
        private LocalDateTime time;
        private LocalDateTime serverTime;

        public Builder() {
        }

        public Builder(Message copy) {
            this.sender = copy.sender;
            this.addressee = copy.addressee;
            this.message = copy.message;
            this.time = copy.time;
            this.serverTime = copy.serverTime;
        }

        public Builder withSender(Participant sender) {
            this.sender = sender;
            return this;
        }

        public Builder withAddressee(Addressee addressee) {
            this.addressee = addressee;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withTime(LocalDateTime time) {
            this.time = time;
            return this;
        }

        public Builder withServerTime(LocalDateTime serverTime) {
            this.serverTime = serverTime;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
