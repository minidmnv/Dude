package pl.mn.dude.chat.domain.model;

import java.util.UUID;

public class Participant {

    public final UUID id;
    public final String name;

    public Participant() {
        id = UUID.randomUUID();
        name = null;
    }
}
