package pl.mn.dude.chat.infrastructure;

import com.rethinkdb.RethinkDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mn.dude.chat.domain.event.LoginEvent;
import pl.mn.dude.chat.infrastructure.database.RethinkDbConnectionFactory;
import pl.mn.dude.chat.domain.model.Message;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/chat")
public class ChatController {

    protected final Logger log = LoggerFactory.getLogger(ChatController.class);
    private static final RethinkDB r = RethinkDB.r;

    @Autowired
    private RethinkDbConnectionFactory connectionFactory;

    @SubscribeMapping("/chat.participants")
    public Set<LoginEvent> retrieveParticipants() {
        // TODO: 24.09.2018 zaimplementowac
        return null;
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        message = new Message.Builder(message).withServerTime(LocalDateTime.now()).build();

        return message;
    }

}
