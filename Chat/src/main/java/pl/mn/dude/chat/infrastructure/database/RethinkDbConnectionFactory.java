package pl.mn.dude.chat.infrastructure.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RethinkDbConnectionFactory {

    private final String host;

    public RethinkDbConnectionFactory(String host) {
        this.host = host;
    }

    public Connection createConnection() {
        return RethinkDB.r.connection().hostname(host).connect();
    }
}
