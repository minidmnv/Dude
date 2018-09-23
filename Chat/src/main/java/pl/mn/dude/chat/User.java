package pl.mn.dude.chat;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;

    public User() {
        id = UUID.randomUUID();
        name = null;
    }
}
